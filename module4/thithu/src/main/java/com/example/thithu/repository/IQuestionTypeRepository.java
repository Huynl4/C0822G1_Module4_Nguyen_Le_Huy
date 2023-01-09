package com.example.thithu.repository;

import com.example.thithu.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
