package com.example.freshbe.service.impl;

import com.example.freshbe.model.Product;
import com.example.freshbe.repository.IProductRepository;
import com.example.freshbe.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getListVegetable(Pageable pageable) {
        return productRepository.getListVegetable(pageable);
    }

    @Override
    public List<Product> getListFruit(Pageable pageable) {
        return productRepository.getListFruit(pageable);
    }
}
