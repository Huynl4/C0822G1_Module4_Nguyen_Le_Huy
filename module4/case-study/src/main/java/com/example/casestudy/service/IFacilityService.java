package com.example.casestudy.service;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    void remove(Long id);

    Facility findById(Long id);

    Page<Facility> search(Pageable pageable, String name, String facilityType);
}
