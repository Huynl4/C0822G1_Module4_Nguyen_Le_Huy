package com.example.casestudy.service;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    List<ContractDto> showAll(Long id);
}
