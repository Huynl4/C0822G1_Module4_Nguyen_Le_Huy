package com.example.thithu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "questionType")
    private Set<QuestionContent> questions;

    public QuestionType() {
    }

    public Set<QuestionContent> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionContent> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
