package com.example.casestudy.repository;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM `furama`.customer where name like %:name% and email like %:email% and customer_type_id like %:customerTypeId% and customer.flag_delete = true", nativeQuery = true)
    Page<Customer> search(Pageable pageable, @Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId);
}
