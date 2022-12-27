package com.example.exercise.service;

import com.example.exercise.model.Book;
import com.example.exercise.model.Oder;

import java.util.List;

public interface IOderService {
    int getIdRent(Book book);

    Oder findByIdRent(int idRent);

    List<Oder> findAllOder();

    void deleteOder(Oder oder);

}

