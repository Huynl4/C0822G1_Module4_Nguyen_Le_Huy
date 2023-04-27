package com.example.freshbe.controller;

import com.example.freshbe.model.Product;
import com.example.freshbe.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")

public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/listVegetable")
    public ResponseEntity<List<Product>> getListVegetable(@RequestParam("page") int page
            , @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> vegetableList = productService.getListVegetable(pageable);
        if (vegetableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vegetableList, HttpStatus.OK);
    }

    @GetMapping("/listFruit")
    public ResponseEntity<List<Product>> getListFruit(@RequestParam("page1") int page1
            , @RequestParam("size1") int size1) {
        Pageable pageable = PageRequest.of(page1, size1);
        List<Product> fruitList = productService.getListFruit(pageable);
        if (fruitList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(fruitList, HttpStatus.OK);
    }
}
