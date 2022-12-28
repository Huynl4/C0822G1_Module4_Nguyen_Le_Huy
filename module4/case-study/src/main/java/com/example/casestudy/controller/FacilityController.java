package com.example.casestudy.controller;

import com.example.casestudy.dto.FacilityDto;
import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.model.facility.FacilityType;
import com.example.casestudy.model.facility.RentType;
import com.example.casestudy.service.IFacilityService;
import com.example.casestudy.service.IFacilityTypeService;
import com.example.casestudy.service.IRentTypeService;
import org.aspectj.lang.annotation.Aspect;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showAndSearch(@RequestParam(required = false, defaultValue = "") String name,
                                @RequestParam(required = false, defaultValue = "") String facilityTypeId,
                                Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Facility> facilities = facilityService.search(pageable, name, facilityTypeId);
        model.addAttribute("facilities", facilities);
        model.addAttribute("name", name);
        model.addAttribute("facilityTypeId", facilityTypeId);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/create";
    }

    @PostMapping("/create")
    public String saveFacility(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        Facility facility = new Facility();
        facility.setFlagDelete(true);
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        return "facility/edit";
    }

    @PostMapping("/edit")
    public String save(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/edit";
        }
        Facility facility = new Facility();
        facility.setFlagDelete(true);
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/facility";
    }
}
