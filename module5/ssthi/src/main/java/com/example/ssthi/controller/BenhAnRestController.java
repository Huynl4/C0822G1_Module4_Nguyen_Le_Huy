package com.example.ssthi.controller;

import com.example.ssthi.model.BenhAn;
import com.example.ssthi.service.IBenhAnService;
import com.example.ssthi.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/benhAns")
public class BenhAnRestController {
    @Autowired
    private IBenhAnService benhAnService;
    @Autowired
    private IBenhNhanService benhNhanService;

    @GetMapping("")
    public ResponseEntity<List<BenhAn>> findAll() {
        List<BenhAn> benhAnList = benhAnService.getAll();
        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BenhAn> delete(@PathVariable("id") Long id) {
        benhAnService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
