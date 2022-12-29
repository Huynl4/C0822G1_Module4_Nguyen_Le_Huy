package com.example.casestudy.service;

import com.example.casestudy.model.employee.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
