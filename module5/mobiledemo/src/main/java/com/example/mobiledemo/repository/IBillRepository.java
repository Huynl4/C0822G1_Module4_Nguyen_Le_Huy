package com.example.mobiledemo.repository;

import com.example.mobiledemo.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
}
