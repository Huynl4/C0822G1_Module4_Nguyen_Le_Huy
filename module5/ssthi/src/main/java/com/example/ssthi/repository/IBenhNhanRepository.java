package com.example.ssthi.repository;

import com.example.ssthi.model.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBenhNhanRepository extends JpaRepository<BenhNhan, Long> {
    @Query(value = "select * from benh_nhan", nativeQuery = true)
    List<BenhNhan> getAll();
}
