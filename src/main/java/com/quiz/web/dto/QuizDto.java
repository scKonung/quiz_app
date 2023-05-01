package com.quiz.web.dto;

import com.quiz.web.models.Type;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizDto {
    private Long id;
    private String name;
    private String content;
    private String photoUrl;
    private List<Type> types;

}
