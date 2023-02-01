package com.example.thithu1.repository;

import com.example.thithu1.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookTypeRepository extends JpaRepository<BookType,Long> {
}
