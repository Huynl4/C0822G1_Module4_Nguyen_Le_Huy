package com.example.phim.service.impl;

import com.example.phim.model.Phim;
import com.example.phim.repository.IPhimRepository;
import com.example.phim.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimService implements IPhimService {
    @Autowired
    private IPhimRepository phimRepository;

    @Override
    public List<Phim> findAll() {
        return phimRepository.findAll();
    }
}
