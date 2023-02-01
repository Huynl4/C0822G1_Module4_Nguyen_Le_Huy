package com.example.phim.repository;

import com.example.phim.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhimRepository extends JpaRepository<Phim, Long> {
}
