package com.example.backend.repository;

import com.example.backend.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface INhanVienRepository extends JpaRepository<NhanVien,Integer> {
}
