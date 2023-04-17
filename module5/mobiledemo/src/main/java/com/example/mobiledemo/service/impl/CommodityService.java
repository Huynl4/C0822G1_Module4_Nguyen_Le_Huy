package com.example.mobiledemo.service.impl;

import com.example.mobiledemo.model.Commodity;
import com.example.mobiledemo.repository.ICommodityRepository;
import com.example.mobiledemo.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService implements ICommodityService {
    @Autowired
    private ICommodityRepository commodityRepository;

    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }
}
