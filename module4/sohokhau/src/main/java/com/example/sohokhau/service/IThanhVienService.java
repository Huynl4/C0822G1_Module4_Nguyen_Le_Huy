package com.example.sohokhau.service;

import com.example.sohokhau.dto.IThanhVienDto;
import com.example.sohokhau.model.ThanhVien;

import java.util.List;

public interface IThanhVienService {
    List<ThanhVien> findAll();

    List<IThanhVienDto> findAllThanhVien(Long id);
}
