package com.example.mobiledemo.service.impl;

import com.example.mobiledemo.model.Bill;
import com.example.mobiledemo.repository.IBillRepository;
import com.example.mobiledemo.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }
}
