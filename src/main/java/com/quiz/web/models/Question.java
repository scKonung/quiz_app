package com.quiz.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> answers;
    private Integer rightAnswerIndex;
    @ManyToOne
    @JoinColumn(name = "quiz_id",nullable = false)
    private Quiz quiz;

}
