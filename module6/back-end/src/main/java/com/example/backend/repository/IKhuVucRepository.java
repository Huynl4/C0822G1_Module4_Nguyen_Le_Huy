package com.example.backend.repository;

import com.example.backend.model.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IKhuVucRepository extends JpaRepository<KhuVuc,Integer> {
}
