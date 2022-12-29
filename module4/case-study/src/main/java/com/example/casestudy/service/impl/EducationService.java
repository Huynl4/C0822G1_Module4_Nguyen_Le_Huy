package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.repository.employee.IEducationRepository;
import com.example.casestudy.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationRepository.findAll();
    }
}
