package com.example.sohokhau.repository;

import com.example.sohokhau.dto.IThanhVienDto;
import com.example.sohokhau.model.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IThanhVienRepository extends JpaRepository<ThanhVien, Long> {
    @Query(value = "select tv.id,tv.member, tv.birthday from thanh_vien tv join ho_khau hk on hk.id = tv.ho_khau_id where hk.id = :id and hk.flag_delete = true ", nativeQuery = true)
    List<IThanhVienDto> findAllThanhVien(@Param("id") Long id);

}
