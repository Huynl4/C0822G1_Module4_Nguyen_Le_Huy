package com.example.backend.repository;

import com.example.backend.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IKhachHangRepository  extends JpaRepository<KhachHang,Integer> {
}
