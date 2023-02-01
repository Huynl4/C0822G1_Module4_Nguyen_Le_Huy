package com.example.phim.service;

import com.example.phim.model.Chieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IChieuService {
    Page<Chieu> search(Pageable pageable, String code, String date,String name);

    void save(Chieu chieu);

    void remove(Long id);

    Chieu findById(Long id);
}
