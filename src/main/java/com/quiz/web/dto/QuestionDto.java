package com.quiz.web.dto;

import com.quiz.web.models.Quiz;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {
    private Long id;
    private String title;
    private List<String> answers;
    private String rightAnswer;
    private Quiz quiz;
}
