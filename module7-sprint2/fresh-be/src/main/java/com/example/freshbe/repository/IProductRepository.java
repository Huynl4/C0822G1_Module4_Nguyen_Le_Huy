package com.example.freshbe.repository;

import com.example.freshbe.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where category_id = 1", nativeQuery = true)
    List<Product> getListVegetable(Pageable pageable);

    @Query(value = "select * from product where category_id = 2", nativeQuery = true)
    List<Product> getListFruit(Pageable pageable);
}
