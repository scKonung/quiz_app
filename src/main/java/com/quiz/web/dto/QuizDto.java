package com.quiz.web.dto;

import com.quiz.web.models.Type;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class QuizDto {
    private Long id;
    @NotEmpty(message = "name of quiz should not be empty")
    private String name;
    @NotEmpty(message = "details of quiz should not be empty")
    private String content;
    private String photoUrl;
    @NotEmpty(message = "types of quiz should not be empty")
    private List<Type> types;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private List<QuestionDto> questions;

}
