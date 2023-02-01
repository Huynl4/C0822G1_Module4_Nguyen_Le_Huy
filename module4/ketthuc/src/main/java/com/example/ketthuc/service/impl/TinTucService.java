package com.example.ketthuc.service.impl;

import com.example.ketthuc.dto.ITinTucDto;
import com.example.ketthuc.model.TinTuc;
import com.example.ketthuc.repository.ITinTucRepository;
import com.example.ketthuc.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinTucService implements ITinTucService {
    @Autowired
    private ITinTucRepository tinTucRepository;


    @Override
    public List<TinTuc> findAll() {
        return tinTucRepository.showALl();
    }

    @Override
    public void save(TinTuc tinTuc) {
        tinTucRepository.save(tinTuc);
    }

    @Override
    public void remove(Long id) {
        TinTuc tinTuc = this.findById(id);
        tinTuc.setFlagDelete(false);
        tinTucRepository.save(tinTuc);
    }

    @Override
    public TinTuc findById(Long id) {
        return tinTucRepository.findById(id).get();
    }

    @Override
    public List<ITinTucDto> findAllTinTuc(Long id) {
        return tinTucRepository.findAllTinTuc(id);
    }


}
