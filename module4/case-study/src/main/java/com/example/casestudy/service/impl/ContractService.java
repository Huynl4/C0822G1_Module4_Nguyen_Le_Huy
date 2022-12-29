package com.example.casestudy.service.impl;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.IContractRepository;
import com.example.casestudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<ContractDto> findAllContractView(Pageable pageable) {
        return contractRepository.findAllContractView(pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }
}
