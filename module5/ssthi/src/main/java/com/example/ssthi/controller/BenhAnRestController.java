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

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody BenhAn benhAn) {
        benhAnService.create(benhAn.getDoctor(), benhAn.getReason(), benhAn.getMethod(), benhAn.getEndDate(), benhAn.getStartDate(), benhAn.getBenhNhan().getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BenhAn> findById(@PathVariable("id") Long id) {
        BenhAn benhAn = benhAnService.findById(id);
        return new ResponseEntity<>(benhAn, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody BenhAn benhAn) {
        benhAnService.update(benhAn.getDoctor(), benhAn.getEndDate(), benhAn.getStartDate(), benhAn.getMethod(), benhAn.getReason(), benhAn.getBenhNhan().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
