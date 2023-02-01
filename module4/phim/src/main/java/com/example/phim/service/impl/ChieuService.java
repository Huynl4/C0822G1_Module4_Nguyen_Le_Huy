package com.example.phim.service.impl;

import com.example.phim.model.Chieu;
import com.example.phim.repository.IChieuRepository;
import com.example.phim.service.IChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChieuService implements IChieuService {
    @Autowired
    private IChieuRepository chieuRepository;

    @Override
    public Page<Chieu> search(Pageable pageable, String code, String date,String name) {
        return chieuRepository.search(pageable,code,date,name);
    }

    @Override
    public void save(Chieu chieu) {
        chieuRepository.save(chieu);
    }

    @Override
    public void remove(Long id) {
        Chieu chieu = this.findById(id);
        chieu.setFlagDelete(false);
        chieuRepository.save(chieu);
    }

    @Override
    public Chieu findById(Long id) {
        return chieuRepository.findById(id).get();
    }
}
