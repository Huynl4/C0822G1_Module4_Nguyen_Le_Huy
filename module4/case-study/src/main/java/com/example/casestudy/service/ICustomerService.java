package com.example.casestudy.service;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void remove(Long id);

    Customer findById(Long id);

    Page<Customer> search(Pageable pageable, String name, String email, String customerType);
}
