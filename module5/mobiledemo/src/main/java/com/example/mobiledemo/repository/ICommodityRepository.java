package com.example.mobiledemo.repository;

import com.example.mobiledemo.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommodityRepository extends JpaRepository<Commodity,Integer> {
}
