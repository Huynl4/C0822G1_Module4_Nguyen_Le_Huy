package com.example.backend.repository;

import com.example.backend.model.SanBong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ISanBongRepository extends JpaRepository<SanBong, Integer> {

    @Query(value = "select * from san_bong where flag_delete = true ", nativeQuery = true)
    List<SanBong> getAll();

    @Modifying
    @Query(value = "update san_bong set flag_delete = false where id =:id", nativeQuery = true)
    void deleteId(@Param("id") Integer id);

    @Modifying
    @Query(value = "insert into san_bong(`name`, address,khu_vuc_id,loai_san_id,time_id,flag_delete) " +
            "values (:name,:address,:khuVuc,:loaiSan,:time, true)", nativeQuery = true)
    void add(@Param("name") String name, @Param("address") String address,
             @Param("khuVuc") String khuVuc, @Param("loaiSan") String loaiSan, @Param("time") String time);

    @Query(value = "select * from san_bong where id =:id", nativeQuery = true)
    SanBong findId(Integer id);

    @Modifying
    @Query(value = "insert into san_bong( " +
            "`name`, " +
            "address, " +
            "khu_vuc_id, " +
            "loai_san_id, " +
            "time_id, " +
            "flag_delete) values " +
            "(:#{#sanBong.name}, " +
            ":#{#sanBong.address}, " +
            ":#{#sanBong.khuVuc.id}, " +
            ":#{#sanBong.loaiSan.id}, " +
            ":#{#sanBong.time.id}, " +
            ":#{#sanBong.flagDelete})",nativeQuery = true)
    void createSanBong(@Param("sanBong") SanBong sanBong);
}
