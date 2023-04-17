package com.example.mobiledemo.service;

import com.example.mobiledemo.model.BillHistory;

import java.util.List;

public interface IBillHistoryService {
    List<BillHistory> findAll();
}
