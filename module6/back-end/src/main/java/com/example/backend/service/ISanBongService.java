package com.example.backend.service;

import com.example.backend.model.SanBong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISanBongService {
    List<SanBong> findAll( );

    void delete(Integer id);

    SanBong findId(Integer id);

    void remove(SanBong sanBong);

    void createSanBong(SanBong sanBong);
}
