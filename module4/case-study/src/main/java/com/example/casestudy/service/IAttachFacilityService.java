package com.example.casestudy.service;

import com.example.casestudy.dto.AttachFacilityDto;
import com.example.casestudy.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    List<AttachFacilityDto> findAllAttach(Long id);
}
