package com.quiz.web.dto;

import com.quiz.web.models.Type;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class QuizDto {
    private Long id;
    private String name;
    private String content;
    private String photoUrl;
    private List<Type> types;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

}
