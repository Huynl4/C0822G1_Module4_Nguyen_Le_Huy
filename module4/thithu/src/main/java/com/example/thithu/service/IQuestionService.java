package com.example.thithu.service;

import com.example.thithu.dto.IQuestionDto;
import com.example.thithu.dto.QuestionDto;
import com.example.thithu.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    Page<QuestionContent> search(Pageable pageable,String title, Integer questionType);

    void save(QuestionContent question);

    void remove(Long id);

    QuestionContent findById(Long id);

    Page<QuestionContent> showList(String title, Pageable pageable);
    List<IQuestionDto> findAllQuestion(Long id);
}
