package com.example.exercise2.service.impl;

import com.example.exercise2.model.Song;
import com.example.exercise2.repository.ISongRepository;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Iterable<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iSongRepository.deleteById(id);
    }
}
