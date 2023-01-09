package com.example.thithu.controller;

import com.example.thithu.dto.IQuestionDto;
import com.example.thithu.dto.QuestionDto;
import com.example.thithu.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions/v1")
@CrossOrigin("*")
public class QuestionRestController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping("{id}")
    public ResponseEntity<List<IQuestionDto>> show(@PathVariable Long id) {
        List<IQuestionDto> questionDtoList = questionService.findAllQuestion(id);
        return new ResponseEntity<>(questionDtoList, HttpStatus.OK);
    }
}
