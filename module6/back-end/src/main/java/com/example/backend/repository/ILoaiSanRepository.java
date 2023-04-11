package com.example.backend.repository;

import com.example.backend.model.LoaiSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ILoaiSanRepository extends JpaRepository<LoaiSan,Integer> {
}
