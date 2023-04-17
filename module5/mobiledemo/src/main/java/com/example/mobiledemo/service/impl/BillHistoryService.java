package com.example.mobiledemo.service.impl;

import com.example.mobiledemo.model.BillHistory;
import com.example.mobiledemo.repository.IBillHistoryRepository;
import com.example.mobiledemo.service.IBillHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillHistoryService  implements IBillHistoryService {
    @Autowired
    private IBillHistoryRepository billHistoryRepository;

    @Override
    public List<BillHistory> findAll() {
        return billHistoryRepository.findAll();
    }
}
