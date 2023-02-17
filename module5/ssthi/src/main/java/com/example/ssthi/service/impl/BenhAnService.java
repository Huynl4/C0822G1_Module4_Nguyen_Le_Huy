package com.example.ssthi.service.impl;

import com.example.ssthi.model.BenhAn;
import com.example.ssthi.repository.IBenhAnRepository;
import com.example.ssthi.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhAnService implements IBenhAnService {
    @Autowired
    private IBenhAnRepository benhAnRepository;

    @Override
    public List<BenhAn> getAll() {
        return benhAnRepository.getAll();
    }

    @Override
    public void delete(Long id) {
        benhAnRepository.deleteId(id);
    }
}
