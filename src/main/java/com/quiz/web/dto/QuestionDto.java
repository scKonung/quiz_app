package com.quiz.web.dto;

import com.quiz.web.models.Quiz;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    private Long id;
    private String title;
    private Quiz quiz;
}
