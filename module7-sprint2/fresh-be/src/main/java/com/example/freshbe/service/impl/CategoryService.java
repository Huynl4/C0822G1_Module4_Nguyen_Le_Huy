package com.example.freshbe.service.impl;

import com.example.freshbe.model.Category;
import com.example.freshbe.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findCategory() {
        return categoryRepository.findAll();
    }
}
