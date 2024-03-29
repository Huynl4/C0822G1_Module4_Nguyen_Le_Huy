package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showAndSearch(@RequestParam(required = false, defaultValue = "") String name,
                                @RequestParam(required = false, defaultValue = "") String email,
                                @RequestParam(required = false, defaultValue = "") String customerTypeId, Model model,
                                @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customers = iCustomerService.search(pageable, name, email, customerTypeId);
        model.addAttribute("customers", customers);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model, Pageable pageable) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        customer.setFlagDelete(true);
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = iCustomerService.findById(id);
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String saveEdit(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, Model model
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/edit";
        }
        Customer customer = new Customer();
        customer.setFlagDelete(true);
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/customer";
    }
}
