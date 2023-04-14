package com.example.backend.service.impl;

import com.example.backend.dto.ICoSoDTO;
import com.example.backend.model.CoSo;
import com.example.backend.repository.ICoSoRepository;
import com.example.backend.service.ICoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoSoService implements ICoSoService {
    @Autowired
    private ICoSoRepository coSoRepository;

    @Override
    public List<CoSo> getAllCoSo() {
        return coSoRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        coSoRepository.deleteId(id);
    }

    @Override
    public CoSo findId(Integer id) {
        return coSoRepository.findId(id);
    }

    @Override
    public List<CoSo> findAll() {
        return coSoRepository.getAll();
    }

    @Override
    public List<ICoSoDTO> search(String coSoName, String coSoPerson) {
        return coSoRepository.search("%" + coSoName + "%","%" + coSoPerson + "%");
    }

    @Override
    public void addCoSo(String address, String dateOpen, String name, String person,int id) {
        coSoRepository.createCoSo(address, dateOpen, name, person);
    }


}
