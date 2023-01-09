package com.example.thithu.controller;

import com.example.thithu.dto.QuestionDto;
import com.example.thithu.model.QuestionContent;
import com.example.thithu.model.QuestionType;
import com.example.thithu.service.IQuestionService;
import com.example.thithu.service.IQuestionTypeService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
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
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IQuestionTypeService questionTypeService;

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "") String title,
                           @RequestParam(required = false, defaultValue = "") String questionTypeId,
                           Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<QuestionContent> questionContents;
        if (questionTypeId.equals("")) {
            questionContents = questionService.showList(title, pageable);
        } else {
            questionContents = questionService.search(pageable, title, Integer.parseInt(questionTypeId));
        }
        model.addAttribute("questionContens", questionContents);
        model.addAttribute("title", title);
        model.addAttribute("questionTypeId", questionTypeId);
        model.addAttribute("questionType", questionTypeService.findAll());
        return "question/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<QuestionType> questionTypeList = questionTypeService.findAll();
        model.addAttribute("questionDto", new QuestionDto());
        model.addAttribute("questionTypeList", questionTypeList);
        return "question/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("questionDto") QuestionDto questionDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            return "question/create";
        }
        QuestionContent questionContent = new QuestionContent();
        questionContent.setFlagDelete(true);
        BeanUtils.copyProperties(questionDto, questionContent);
        questionService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/question";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        questionService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa ok");
        return "redirect:/question";
    }
}
