package com.example.sohokhau.service.impl;

import com.example.sohokhau.dto.IThanhVienDto;
import com.example.sohokhau.model.ThanhVien;
import com.example.sohokhau.repository.IThanhVienRepository;
import com.example.sohokhau.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhVienService implements IThanhVienService {
    @Autowired
    private IThanhVienRepository thanhVienRepository;

    @Override
    public List<ThanhVien> findAll() {
        return thanhVienRepository.findAll();

    }

    @Override
    public List<IThanhVienDto> findAllThanhVien(Long id) {
        return thanhVienRepository.findAllThanhVien(id);
    }
}
