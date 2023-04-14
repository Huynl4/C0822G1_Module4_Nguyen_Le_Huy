package com.example.backend.service;

import com.example.backend.dto.ICoSoDTO;
import com.example.backend.model.CoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICoSoService {
    List<CoSo> getAllCoSo();

    void delete(Integer id);

    CoSo findId(Integer id);

    List<CoSo> findAll();

    List<ICoSoDTO> search(String coSoName, String coSoPerson);

    void addCoSo(String address, String dateOpen,String name,String person,int id);
}
