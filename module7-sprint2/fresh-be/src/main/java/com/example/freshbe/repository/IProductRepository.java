package com.example.freshbe.repository;

import com.example.freshbe.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where category_id = 1", nativeQuery = true)
    List<Product> getListVegetable(Pageable pageable);

    @Query(value = "select * from product where category_id = 2", nativeQuery = true)
    List<Product> getListFruit(Pageable pageable);

    @Query(value = "select * from product where product.id = :id", nativeQuery = true)
    Product findByIdProductDetail(long id);

    @Query( value = "select * from product where product.name like concat('%',:keyword,'%')", nativeQuery = true)
    List<Product> getListSearchResults(@Param("keyword") String keyword, Pageable pageable);

    @Query( value = "select * from product where product.name like concat('%',:keyword,'%') and product.category_id =:id", nativeQuery = true)
    List<Product> getListSearchResultsOption(@Param("keyword") String keyword,@Param("id") int id, Pageable pageable);


    @Query(value = "select * from product " +
            "where id =:id ",
            nativeQuery = true)
    Product findProduct(@Param("id") long id);
}
