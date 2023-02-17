package com.example.ssthi.service;

import com.example.ssthi.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> getAll();
    void delete(Long id);
}
