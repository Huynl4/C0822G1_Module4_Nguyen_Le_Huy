package com.example.ketthuc.service;

import com.example.ketthuc.dto.ITinTucDto;
import com.example.ketthuc.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITinTucService {

    List<TinTuc> findAll();

    void save(TinTuc tinTuc);

    void remove(Long id);

    TinTuc findById(Long id);

    List<ITinTucDto> findAllTinTuc(Long id);
}
