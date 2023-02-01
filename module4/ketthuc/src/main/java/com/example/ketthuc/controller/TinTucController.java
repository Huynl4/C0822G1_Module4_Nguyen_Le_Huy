package com.example.ketthuc.controller;

import com.example.ketthuc.dto.TintucDto;
import com.example.ketthuc.model.DanhMuc;
import com.example.ketthuc.model.TinTuc;
import com.example.ketthuc.service.IDanhMucService;
import com.example.ketthuc.service.ITinTucService;
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
@RequestMapping("/tintuc")
public class TinTucController {
    @Autowired
    private ITinTucService tinTucService;
    @Autowired
    private IDanhMucService danhMucService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("tintucs", tinTucService.findAll());
        model.addAttribute("danhmucs", danhMucService.findAll());
        return "tintuc/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        tinTucService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công!");
        return "redirect:/tintuc";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<DanhMuc> danhMucList = danhMucService.findAll();
        model.addAttribute("tinTucDto", new TintucDto());
        model.addAttribute("danhMucList", danhMucList);
        return "tintuc/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("tinTucDto") TintucDto tintucDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new TintucDto().validate(tintucDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("danhMucList", danhMucService.findAll());
            return "tintuc/create";
        }
        TinTuc tinTuc = new TinTuc();
        tinTuc.setFlagDelete(true);
        BeanUtils.copyProperties(tintucDto, tinTuc);
        tinTucService.save(tinTuc);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/tintuc";
    }
}
