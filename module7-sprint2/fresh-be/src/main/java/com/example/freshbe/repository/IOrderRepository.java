package com.example.freshbe.repository;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Oder, Long> {
    @Query(value = "select * from oder where account_id =:id",nativeQuery = true)
    Page<Oder> findAllByAccountId(@Param("id") Integer account_id, Pageable pageable);
}
