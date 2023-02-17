package com.example.ssthi.repository;

import com.example.ssthi.model.BenhAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBenhAnRepository extends JpaRepository<BenhAn, Long> {
    @Query(value = "select * from benh_an", nativeQuery = true)
    List<BenhAn> getAll();

    @Modifying
    @Query(value = "delete from benh_an where benh_an.id=:id", nativeQuery = true)
    void deleteId(@Param("id") Long id);
}
