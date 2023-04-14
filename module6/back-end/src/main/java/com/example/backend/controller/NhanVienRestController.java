package com.example.backend.controller;

import com.example.backend.model.CoSo;
import com.example.backend.model.NhanVien;
import com.example.backend.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nhanvien")
@CrossOrigin("*")
public class NhanVienRestController {
    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping("/list")
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> nhanVienList = nhanVienService.getAllNhanVien();
        if (nhanVienList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nhanVienList, HttpStatus.OK);
    }
}
