package com.example.exercise.service.impl;

import com.example.exercise.model.Book;
import com.example.exercise.repository.IBookRepository;
import com.example.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllByNameContaining(String search, Pageable pageable) {
        return iBookRepository.findAllByNameContaining(search, pageable);
    }

    @Override
    public void rentBook(int id) {
        iBookRepository.rentBook(id);
    }

    @Override
    public void payBook(int id) {
        iBookRepository.payBook(id);
    }

    @Override
    public Optional<Book> findById(int id) {
        return iBookRepository.findById(id);
    }
}
