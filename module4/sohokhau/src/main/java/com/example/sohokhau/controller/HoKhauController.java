package com.example.sohokhau.controller;

import com.example.sohokhau.dto.HoKhauDto;
import com.example.sohokhau.model.HoKhau;
import com.example.sohokhau.model.ThanhVien;
import com.example.sohokhau.service.IHoKhauService;
import com.example.sohokhau.service.IThanhVienService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/hokhau")
public class HoKhauController {
    @Autowired
    private IHoKhauService hoKhauService;
    @Autowired
    private IThanhVienService thanhVienService;

//    @GetMapping("")
//    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable) {
//        model.addAttribute("hokhaus", hoKhauService.findALl(pageable));
//        model.addAttribute("thanhviens", thanhVienService.findAll());
//        return "hokhau/list";
//    }

    @GetMapping("")
    public String showAndSearch(@RequestParam(required = false, defaultValue = "") String name,
                                Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<HoKhau> hoKhaus = hoKhauService.search(pageable, name);
        model.addAttribute("hoKhaus", hoKhaus);
        model.addAttribute("name", name);
        return "hokhau/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        hoKhauService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa ok");
        return "redirect:/hokhau";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        HoKhauDto hoKhauDto = new HoKhauDto();
        HoKhau hoKhau = hoKhauService.findById(id);
        List<ThanhVien> thanhVienList = thanhVienService.findAll();
        model.addAttribute("thanhVienList", thanhVienList);
        BeanUtils.copyProperties(hoKhau, hoKhauDto);
        model.addAttribute("hoKhauDto", hoKhauDto);
        return "hokhau/edit";
    }

    @PostMapping("/edit")
    public String saveEdit(@Validated @ModelAttribute("hoKhauDto") HoKhauDto hoKhauDto, BindingResult bindingResult, Model model
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<ThanhVien> thanhVienList = thanhVienService.findAll();
            model.addAttribute("thanhVienList", thanhVienList);
            return "hokhau/edit";
        }
        HoKhau hoKhau = new HoKhau();
        hoKhau.setFlagDelete(true);
        BeanUtils.copyProperties(hoKhauDto, hoKhau);
        hoKhauService.save(hoKhau);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/hokhau";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("hoKhauDto", new HoKhauDto());
        model.addAttribute("thanhVienList", thanhVienService.findAll());
        return "hokhau/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("hoKhauDto") HoKhauDto hoKhauDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new HoKhauDto().validate(hoKhauDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("thanhVienList", thanhVienService.findAll());
            return "hokhau/create";
        }
        HoKhau hoKhau = new HoKhau();
        hoKhau.setFlagDelete(true);
        BeanUtils.copyProperties(hoKhauDto, hoKhau);
        hoKhauService.save(hoKhau);
        redirectAttributes.addFlashAttribute("mess", "thêm mới ok");
        return "redirect:/hokhau";
    }
}
