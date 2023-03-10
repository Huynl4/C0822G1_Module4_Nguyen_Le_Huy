package com.example.casestudy.controller;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.AttachFacility;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<ContractDto> contractDtoPage = contractService.findAllContractView(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("contractDtoPage", contractDtoPage);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerPage", customerService.findAll());
        model.addAttribute("facilityPage", facilityService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("employeePage", employeeService.findAll(pageable));
        return "contract/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contract") Contract contract, Model model) {
        model.addAttribute("mess", 1);
        contractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping("/attach")
    public String saveAttach(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Long id, Model model) {
        model.addAttribute("contractDetails", contractDetailService.showAll(id));

        return "redirect:/contract";
    }

}
