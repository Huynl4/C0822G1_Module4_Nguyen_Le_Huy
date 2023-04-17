package com.example.mobiledemo.service;

import com.example.mobiledemo.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> findAll();
}
