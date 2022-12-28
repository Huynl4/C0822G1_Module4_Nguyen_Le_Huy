package com.example.casestudy.service.impl;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.repository.facility.IFacilityRepository;
import com.example.casestudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Long id) {
        Facility facility = this.findById(id);
        facility.setFlagDelete(false);
        facilityRepository.save(facility);
    }

    @Override
    public Facility findById(Long id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Page<Facility> search(Pageable pageable, String name, String facilityType) {
        return facilityRepository.search(pageable, name, facilityType);
    }
}
