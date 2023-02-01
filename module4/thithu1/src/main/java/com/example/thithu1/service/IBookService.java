package com.example.thithu1.service;

import com.example.thithu1.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    void remove(Long id);

    Book findById(Long id);
    Page<Book> search(Pageable pageable,String title,String bookTypeId);
}
