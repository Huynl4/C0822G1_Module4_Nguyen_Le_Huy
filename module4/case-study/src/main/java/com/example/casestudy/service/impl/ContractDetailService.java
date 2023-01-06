package com.example.casestudy.service.impl;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contract.IContractDetailRepository;
import com.example.casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDto> showAll(Long id) {
        return contractDetailRepository.showAll(id);
    }
}
