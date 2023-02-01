package com.example.ketthuc.repository;

import com.example.ketthuc.dto.ITinTucDto;
import com.example.ketthuc.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITinTucRepository extends JpaRepository<TinTuc, Long> {
    @Query(value = "select * from tin_tuc where tin_tuc.flag_delete=true ", nativeQuery = true)
    List<TinTuc> showALl();


    @Query(value = "select tt.id,tt.tieu_de as tieude,dm.ten_danh_muc as tendanhmuc, tt.noi_dung as noidung,tt.ngay_dang as ngaydang, tt.phong_vien as phongvien  from tin_tuc tt join danh_muc dm on dm.id = tt.danh_muc_id where tt.id =:id and tt.flag_delete = true", nativeQuery = true)
    List<ITinTucDto> findAllTinTuc(@Param("id") Long id);

}
