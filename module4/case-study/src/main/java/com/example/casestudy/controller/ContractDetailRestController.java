package com.example.casestudy.controller;

import com.example.casestudy.dto.AttachFacilityDto;
import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.service.IAttachFacilityService;
import com.example.casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts/v1")
@CrossOrigin("*")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;

//    @GetMapping("{id}")
//    public List<ContractDto> showAll(@PathVariable Long id) {
//        return contractDetailService.showAll(id);
//    }

    @GetMapping("{id}")
    public ResponseEntity<List<AttachFacilityDto>> showAttach(@PathVariable Long id) {
        List<AttachFacilityDto> attachFacilityDtos = attachFacilityService.findAllAttach(id);
        return new ResponseEntity<>(attachFacilityDtos, HttpStatus.OK);
    }
}
