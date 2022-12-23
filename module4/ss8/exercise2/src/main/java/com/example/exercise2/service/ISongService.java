package com.example.exercise2.service;

import com.example.exercise2.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();

    void save(Song song);

    Optional<Song> findById(Long id);

    void remove(Long id);
}
