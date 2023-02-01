package com.example.ketthuc.controller;

import com.example.ketthuc.dto.ITinTucDto;
import com.example.ketthuc.dto.TintucDto;
import com.example.ketthuc.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tintuc/v1")
public class TinTucRestController {
    @Autowired
    private ITinTucService tinTucService;

    @GetMapping("{id}")
    public ResponseEntity<List<ITinTucDto>> show(@PathVariable Long id) {
        List<ITinTucDto> tinTucDtoList = tinTucService.findAllTinTuc(id);
        return new ResponseEntity<>(tinTucDtoList, HttpStatus.OK);
    }
}
