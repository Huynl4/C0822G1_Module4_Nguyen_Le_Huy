package com.example.sohokhau.controller;

import com.example.sohokhau.dto.IThanhVienDto;
import com.example.sohokhau.service.IThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thanhviens/v1")
@CrossOrigin("*")
public class ThanhVienRestController {
    @Autowired
    private IThanhVienService thanhVienService;

    @GetMapping("/{id}")
    public ResponseEntity<List<IThanhVienDto>> show(@PathVariable Long id) {
        List<IThanhVienDto> thanhVienDtoList = thanhVienService.findAllThanhVien(id);
        return new ResponseEntity<>(thanhVienDtoList, HttpStatus.OK);
    }
}
