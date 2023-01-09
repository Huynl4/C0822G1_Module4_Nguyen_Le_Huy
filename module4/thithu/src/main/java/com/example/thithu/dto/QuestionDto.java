package com.example.thithu.dto;

import com.example.thithu.model.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class QuestionDto implements Validator {
    private Long id;

    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 100)
    private String title;

    @NotBlank(message = "không được để trống")
    @Size(min = 10, max = 500)
    private String content;

    @NotBlank(message = "không được để trống")
    private String answer;

    @NotBlank(message = "không được để trống")
    private String date;

    @NotBlank(message = "không được để trống")
    private String status;
    private QuestionType questionType;

    public QuestionDto() {
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
