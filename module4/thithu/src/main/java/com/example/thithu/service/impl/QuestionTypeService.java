package com.example.thithu.service.impl;

import com.example.thithu.model.QuestionType;
import com.example.thithu.repository.IQuestionTypeRepository;
import com.example.thithu.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
