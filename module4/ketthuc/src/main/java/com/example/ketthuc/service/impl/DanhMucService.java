package com.example.ketthuc.service.impl;

import com.example.ketthuc.model.DanhMuc;
import com.example.ketthuc.repository.IDanhMucRepository;
import com.example.ketthuc.service.IDanhMucService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }
}
