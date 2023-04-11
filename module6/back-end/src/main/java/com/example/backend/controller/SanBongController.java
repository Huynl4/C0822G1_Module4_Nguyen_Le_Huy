package com.example.backend.controller;

import com.example.backend.model.SanBong;
import com.example.backend.service.ISanBongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/sanbong")
public class SanBongController {
    @Autowired
    private ISanBongService sanBongService;


    @GetMapping("")
    public ResponseEntity<List<SanBong>> findAll() {
        List<SanBong> sanBongList = sanBongService.findAll();
        return new ResponseEntity<>(sanBongList, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SanBong> delete(@PathVariable("id") Integer id) {
        sanBongService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody SanBong sanBong) {
        sanBongService.createSanBong(sanBong);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SanBong> findById(@PathVariable("id") Integer id) {
        SanBong sanBong = sanBongService.findId(id);
        return new ResponseEntity<>(sanBong, HttpStatus.OK);
    }
}
