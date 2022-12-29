package com.example.casestudy.service;

import com.example.casestudy.dto.IContractDetailDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    List<IContractDetailDto> showAll(Long id);
}
