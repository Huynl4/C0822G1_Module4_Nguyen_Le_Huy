package com.example.sohokhau.service.impl;

import com.example.sohokhau.model.HoKhau;
import com.example.sohokhau.repository.IHoKhauRepository;
import com.example.sohokhau.service.IHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HoKhauService implements IHoKhauService {
    @Autowired
    private IHoKhauRepository hoKhauRepository;

    @Override
    public Page<HoKhau> findALl(Pageable pageable) {
        return hoKhauRepository.showList(pageable);
    }

    @Override
    public void save(HoKhau hoKhau) {
        hoKhauRepository.save(hoKhau);
    }

    @Override
    public void remove(Long id) {
        HoKhau hoKhau = this.findById(id);
        hoKhau.setFlagDelete(false);
        hoKhauRepository.save(hoKhau);
    }

    @Override
    public HoKhau findById(Long id) {
        return hoKhauRepository.findById(id).get();
    }

    @Override
    public Page<HoKhau> search(Pageable pageable, String name) {
        return hoKhauRepository.search(pageable,name);
    }
}
