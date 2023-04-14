package com.example.backend.service.impl;

import com.example.backend.model.NhanVien;
import com.example.backend.repository.INhanVienRepository;
import com.example.backend.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService implements INhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }
}
