package com.quiz.web.mapper;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;


//the class, where save all map method for Quiz
public class Mapper {
    //mapping method fro dto to quiz
    public static Quiz mapToModel(QuizDto quizDto) {
        return  Quiz.builder()
                .id(quizDto.getId())
                .name(quizDto.getName())
                .content(quizDto.getContent())
                .photoUrl(quizDto.getPhotoUrl())
                .types(quizDto.getTypes())
                .updateOn(quizDto.getUpdateOn())
                .createdOn(quizDto.getCreatedOn())
                //.questions(quizDto.getQuestions().stream().map(questionDto -> mapToQuestion(questionDto)).collect(Collectors.toList()))
                .build();
    }
//mapping method from quiz to dto
    public static QuizDto mapToDto(Quiz quiz) {
        return  QuizDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .content(quiz.getContent())
                .photoUrl(quiz.getPhotoUrl())
                .types(quiz.getTypes())
                .createdOn(quiz.getCreatedOn())
                .updateOn(quiz.getUpdateOn())
                //.questions(quiz.getQuestions().stream().map(question -> mapToQuestionDto(question)).collect(Collectors.toList()))
                .build();
    }
}
