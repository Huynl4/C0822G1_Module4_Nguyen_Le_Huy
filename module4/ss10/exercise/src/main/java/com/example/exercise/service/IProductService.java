package com.example.exercise.service;

import com.example.exercise.model.Product;

import java.util.List;

public interface IProductService {
    Product findById(Long id);

    List<Product> findAll();
}
