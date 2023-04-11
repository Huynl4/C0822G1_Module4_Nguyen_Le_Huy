package com.example.backend.service.impl;

import com.example.backend.model.SanBong;
import com.example.backend.repository.ISanBongRepository;
import com.example.backend.service.ISanBongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanBongService implements ISanBongService {
    @Autowired
    private ISanBongRepository sanBongRepository;

    @Override
    public List<SanBong> findAll( ) {
        return sanBongRepository.getAll();
    }

    @Override
    public void delete(Integer id) {
        sanBongRepository.deleteId(id);
    }

//
//    @Override
//    public void create(String name, String address, String khuVuc, String loaiSan, String time) {
//        sanBongRepository.add(name, address, khuVuc, loaiSan, time);
//    }

    @Override
    public SanBong findId(Integer id) {
        return sanBongRepository.findId(id);
    }

    @Override
    public void remove(SanBong sanBong) {
        sanBongRepository.delete(sanBong);
    }

    @Override
    public void createSanBong(SanBong sanBong) {
        sanBongRepository.createSanBong(sanBong);
    }


}
