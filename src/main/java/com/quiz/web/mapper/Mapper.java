package com.quiz.web.mapper;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Question;
import com.quiz.web.models.Quiz;

import java.util.stream.Collectors;


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
                .questions(quiz.getQuestions().stream().map(Mapper::mapToDto).collect(Collectors.toList()))
                .build();
    }
    //mapping method for map question model to dto
    public static QuestionDto mapToDto(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .answers(question.getAnswers())
                .rightAnswer(question.getRightAnswer())
                .quiz(question.getQuiz())
                .build();
    }
    //mapping method for map question dto to model
    public static Question mapToModel(QuestionDto questionDto) {
        return Question.builder()
                .id(questionDto.getId())
                .title(questionDto.getTitle())
                .rightAnswer(questionDto.getRightAnswer())
                .answers(questionDto.getAnswers())
                .quiz(questionDto.getQuiz())
                .build();
    }
}
