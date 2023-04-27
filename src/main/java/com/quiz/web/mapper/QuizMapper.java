package com.quiz.web.mapper;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;

public class QuizMapper {
    public static Quiz mapToQuiz(QuizDto quizDto) {
        Quiz quiz = Quiz.builder()
                .id(quizDto.getId())
                .name(quizDto.getName())
                .content(quizDto.getContent())
                .photoUrl(quizDto.getPhotoUrl())
                .types(quizDto.getTypes())
                .build();
        return quiz;
    }

    public static QuizDto mapToQuizDto(Quiz quiz) {
        QuizDto quizDto = QuizDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .content(quiz.getContent())
                .photoUrl(quiz.getPhotoUrl())
                .types(quiz.getTypes())
                .build();
        return quizDto;
    }
}
