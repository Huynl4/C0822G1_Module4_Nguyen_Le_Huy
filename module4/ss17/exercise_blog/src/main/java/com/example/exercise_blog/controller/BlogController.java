package com.example.exercise_blog.controller;

import com.example.exercise_blog.model.Blog;
import com.example.exercise_blog.service.IBlogService;
import com.example.exercise_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String showAndSearch(@PageableDefault(size = 3) Pageable pageable,
                                @RequestParam(defaultValue = "") String title, Model model) {
        Page<Blog> blogPage = iBlogService.search(title, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("title", title);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String saveCreate(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "thêm mới ok");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Blog blogList = iBlogService.findById(id);
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "sửa ok");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String showDelete(@RequestParam("deleteId") Long id) {
        iBlogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("{id}/view")
    public String showView(@PathVariable Long id, Model model) {
        Blog blogList = iBlogService.findById(id);
        model.addAttribute("blogList", blogList);
        return "blog/view";
    }
}
