package com.example.exercise.repository;

import com.example.exercise.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOderRepository extends JpaRepository<Oder, Long> {

    @Query(value = "select * from oder where id_rent !=  0", nativeQuery = true)
    List<Oder> findAllOder();

    @Transactional
    @Modifying
    @Query(value = "delete  from oder where id_rent  = :id", nativeQuery = true)
    void deleteOder(@Param("id") int idRent);
}
