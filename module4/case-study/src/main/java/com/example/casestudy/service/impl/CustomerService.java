package com.example.casestudy.service.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.ICustomerRepository;
import com.example.casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer = this.findById(id);
        customer.setFlagDelete(false);
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }


    @Override
    public Page<Customer> search(Pageable pageable, String name, String email, String customerType) {
        return iCustomerRepository.search(pageable, name, email, customerType);
    }
}
