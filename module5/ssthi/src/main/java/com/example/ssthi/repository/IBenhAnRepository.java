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

    @Modifying
    @Query(value = "insert into benh_an(doctor,end_date,start_date,method,reason,benh_nhan_id) values (:doctor,:endDate,:startDate,:method,:reason,:benhNhan)", nativeQuery = true)
    void create(@Param("doctor") String doctor,
                @Param("endDate") String endDate,
                @Param("startDate") String startDate,
                @Param("method") String method,
                @Param("reasom") String reason,
                @Param("benhNhanId") Long benhNhanId);


    @Query(value = "select * from benh_an where id =:id", nativeQuery = true)
    BenhAn findId(@Param("id") Long id);

    @Modifying
    @Query(value = "update benh_an set doctor =:doctor,end_date =:endDate,start_date =:startDate, method =:method,reason =:reason,benh_nhan_id =:benhNhanId", nativeQuery = true)
    void update(@Param("doctor") String doctor,
                @Param("endDate") String endDate,
                @Param("startDate") String startDate,
                @Param("method") String method,
                @Param("reason") String reason,
                @Param("benhNhanId") Long id);
}
