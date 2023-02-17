package com.example.ssthi.service.impl;

import com.example.ssthi.model.BenhNhan;
import com.example.ssthi.repository.IBenhNhanRepository;
import com.example.ssthi.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BenhNhanService implements IBenhNhanService {
    @Autowired
    private IBenhNhanRepository benhNhanRepository;

    @Override
    public List<BenhNhan> getAll() {
        return benhNhanRepository.getAll();
    }
}
