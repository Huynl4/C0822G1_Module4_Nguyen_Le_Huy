package com.example.sohokhau.service;

import com.example.sohokhau.model.HoKhau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHoKhauService {
    Page<HoKhau> findALl(Pageable pageable);

    void save(HoKhau hoKhau);

    void remove(Long id);

    HoKhau findById(Long id);
    Page<HoKhau> search(Pageable pageable,String name);
}
