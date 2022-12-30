package com.example.exercise_blog.service;

import com.example.exercise_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> search(String search, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void remove(Long id);

    List<Blog> searchTitle(String title);
}
