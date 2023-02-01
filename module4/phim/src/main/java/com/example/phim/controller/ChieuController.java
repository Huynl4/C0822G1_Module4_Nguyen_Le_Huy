package com.example.phim.controller;

import com.example.phim.dto.ChieuDto;
import com.example.phim.model.Chieu;
import com.example.phim.model.Phim;
import com.example.phim.service.IChieuService;
import com.example.phim.service.IPhimService;
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

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/chieu")
public class ChieuController {
    @Autowired
    private IChieuService chieuService;
    @Autowired
    private IPhimService phimService;

    @GetMapping("")
    public String showSearch(@RequestParam(required = false, defaultValue = "") String code,
                             @RequestParam(required = false, defaultValue = "") String date,
                             @RequestParam(required = false, defaultValue = "") String name,
                             @PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<Chieu> chieus = chieuService.search(pageable, code, date, name);
        model.addAttribute("chieus", chieus);
        model.addAttribute("code", code);
        model.addAttribute("date", date);
        model.addAttribute("name", name);
        model.addAttribute("phims", phimService.findAll());
        return "chieu/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<Phim> phimList = phimService.findAll();
        model.addAttribute("chieuDto", new ChieuDto());
        model.addAttribute("phimList", phimList);
        return "chieu/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("chieuDto") ChieuDto chieuDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new ChieuDto().validate(chieuDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("phimList", phimService.findAll());
            return "chieu/create";
        }
        Chieu chieu = new Chieu();
        chieu.setFlagDelete(true);
        BeanUtils.copyProperties(chieuDto, chieu);
        chieuService.save(chieu);
        redirectAttributes.addFlashAttribute("mess", "thêm mới ok");
        return "redirect:/chieu";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        chieuService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa ok");
        return "redirect:/chieu";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        ChieuDto chieuDto = new ChieuDto();
        Chieu chieu = chieuService.findById(id);
        List<Phim> phimList = phimService.findAll();
        model.addAttribute("phimList", phimList);
        BeanUtils.copyProperties(chieu, chieuDto);
        model.addAttribute("chieuDto", chieuDto);
        return "chieu/edit";
    }

    @PostMapping("/edit")
    public String saveEdit(@Validated @ModelAttribute("chieuDto") ChieuDto chieuDto, BindingResult bindingResult, Model model
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<Phim> phimList = phimService.findAll();
            model.addAttribute("phimList", phimList);
            return "chieu/edit";
        }
        Chieu chieu = new Chieu();
        chieu.setFlagDelete(true);
        BeanUtils.copyProperties(chieuDto, chieu);
        chieuService.save(chieu);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/chieu";
    }
}
