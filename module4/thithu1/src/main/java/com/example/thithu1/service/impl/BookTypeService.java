package com.example.thithu1.service.impl;

import com.example.thithu1.model.BookType;
import com.example.thithu1.repository.IBookTypeRepository;
import com.example.thithu1.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService implements IBookTypeService {
    @Autowired
    private IBookTypeRepository bookTypeRepository;

    @Override
    public List<BookType> findAll() {
        return bookTypeRepository.findAll();
    }
}
