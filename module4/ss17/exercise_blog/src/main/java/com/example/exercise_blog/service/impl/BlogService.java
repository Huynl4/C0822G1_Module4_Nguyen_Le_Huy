package com.example.exercise_blog.service.impl;

import com.example.exercise_blog.model.Blog;
import com.example.exercise_blog.repository.IBlogRepository;
import com.example.exercise_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> search(String search, Pageable pageable) {
        return iBlogRepository.findAllByTitleContaining(pageable, search);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.deleteById(id);
    }
}
