package com.example.ketthuc.repository;

import com.example.ketthuc.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc,Long> {
}
