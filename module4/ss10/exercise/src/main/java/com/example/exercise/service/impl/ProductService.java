package com.example.exercise.service.impl;

import com.example.exercise.model.Product;
import com.example.exercise.repository.IProductRepository;
import com.example.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}
