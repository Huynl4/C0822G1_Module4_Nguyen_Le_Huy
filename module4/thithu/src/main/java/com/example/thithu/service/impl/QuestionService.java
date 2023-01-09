package com.example.thithu.service.impl;

import com.example.thithu.dto.IQuestionDto;
import com.example.thithu.dto.QuestionDto;
import com.example.thithu.model.QuestionContent;
import com.example.thithu.repository.IQuestionRepository;
import com.example.thithu.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;


    @Override
    public Page<QuestionContent> search(Pageable pageable, String title, Integer questionType) {
        return questionRepository.search(pageable, title, questionType);
    }

    @Override
    public void save(QuestionContent question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        QuestionContent question = this.findById(id);
        question.setFlagDelete(false);
        questionRepository.save(question);
    }

    @Override
    public QuestionContent findById(Long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Page<QuestionContent> showList(String title, Pageable pageable) {
        return questionRepository.showList(title,pageable);
    }

    @Override
    public List<IQuestionDto> findAllQuestion(Long id) {
        return questionRepository.findAllQuestion(id);
    }

}
