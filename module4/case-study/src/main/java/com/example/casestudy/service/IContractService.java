package com.example.casestudy.service;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<ContractDto> findAllContractView(Pageable pageable);

    Page<Contract> findAll(Pageable pageable);

    Contract findById(Long id);

    void save(Contract contract);

    void remove(Long id);

}
