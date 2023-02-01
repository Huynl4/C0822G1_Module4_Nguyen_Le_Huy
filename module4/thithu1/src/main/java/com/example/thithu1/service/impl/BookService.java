package com.example.thithu1.service.impl;

import com.example.thithu1.model.Book;
import com.example.thithu1.repository.IBookRepository;
import com.example.thithu1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        Book book = this.findById(id);
        book.setFlagDelete(false);
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Page<Book> search(Pageable pageable, String title, String bookTypeId) {
        return bookRepository.search(pageable,title,bookTypeId);
    }


}
