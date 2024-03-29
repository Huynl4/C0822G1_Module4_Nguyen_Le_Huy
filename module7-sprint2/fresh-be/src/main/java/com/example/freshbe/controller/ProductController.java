package com.example.freshbe.controller;

import com.example.freshbe.model.*;
import com.example.freshbe.service.IAccountService;
import com.example.freshbe.service.IOderDetailService;
import com.example.freshbe.service.IOrderService;
import com.example.freshbe.service.IProductService;
import com.example.freshbe.service.impl.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOderDetailService oderDetailService;

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

    @GetMapping("findProductById/{id}")
    public ResponseEntity<Product> findByIdProductDetail(@PathVariable("id") int id) {
        Product product = productService.findByIdProductDetail(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @GetMapping("/getListSearchResults")
    public ResponseEntity<List<Product>> getListSearchResults(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("keyword") String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> listSearchResults = productService.getListSearchResults(keyword, pageable);
        if (listSearchResults.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listSearchResults, HttpStatus.OK);
    }

    @GetMapping("listProductCategory")
    public ResponseEntity<List<Category>> aquaTypeList() {
        List<Category> aquaType = categoryService.findCategory();
        if (aquaType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(aquaType, HttpStatus.OK);
        }
    }

    @GetMapping("/changeListForOptionList")
    public ResponseEntity<List<Product>> getListSearchResultsByOption(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("keyword") String keyword,
            @RequestParam("id") int id) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> listSearchResults = productService.getListSearchResultsOption(keyword, id, pageable);
//        if (listSearchResults.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(listSearchResults, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Account> findById(@PathVariable long id) {
        Account accountList = accountService.findByIdAccount(id);
        if (accountList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("/oder/{id}")
    public ResponseEntity<Page<Oder>> getListOder(@PathVariable("id") int id,
                                                  @PageableDefault(size = 3) Pageable pageable) {
        Page<Oder> oderPage = orderService.findAllByAccountId(id, pageable);
        return new ResponseEntity<>(oderPage, HttpStatus.OK);
    }

    @GetMapping("/oderDetail/{id}")
    public ResponseEntity<List<OderDetail>> getListOderDetail(@PathVariable("id") int id) {
        List<OderDetail> oderDetailList = oderDetailService.oderDetailById(id);
        return new ResponseEntity<>(oderDetailList, HttpStatus.OK);
    }
}
