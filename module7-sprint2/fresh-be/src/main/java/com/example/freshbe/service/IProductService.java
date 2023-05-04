package com.example.freshbe.service;

import com.example.freshbe.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getListVegetable(Pageable pageable);
    List<Product> getListFruit(Pageable pageable);
    Product findByIdProductDetail(int id);
    List<Product> getListSearchResults(String keyword, Pageable pageable);

    List<Product> getListSearchResultsOption(String keyword, int id, Pageable pageable);
}
