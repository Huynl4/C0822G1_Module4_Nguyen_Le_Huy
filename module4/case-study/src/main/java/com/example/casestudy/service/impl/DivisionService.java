package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.Division;
import com.example.casestudy.repository.employee.IDivisionRepository;
import com.example.casestudy.service.IDivisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisonService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
