package com.example.exercise_blog.service;

import com.example.exercise_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Category category);


}
