package com.example.sohokhau.repository;

import com.example.sohokhau.model.HoKhau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHoKhauRepository extends JpaRepository<HoKhau, Long> {
    @Query(value = "select * from ho_khau where flag_delete=true", nativeQuery = true)
    Page<HoKhau> showList(Pageable pageable);


    @Query(value = "select * from ho_khau where name like concat('%',:name,'%') and ho_khau.flag_delete=true", nativeQuery = true)
    Page<HoKhau> search(Pageable pageable, String name);
}
