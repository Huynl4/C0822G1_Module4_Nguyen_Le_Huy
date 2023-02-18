package com.example.ssthi.service;

import com.example.ssthi.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> getAll();

    void delete(Long id);

    void create(String doctor, String reason, String method,
                String endDate, String startDate,
                Long benhNhanId);

    BenhAn findById(Long id);

    void update(String doctor, String endDate, String startDate, String method, String reason, Long id);
}
