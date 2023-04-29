package com.quiz.web.service;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;

import java.util.List;

public interface QuizService {
    //method for find all quizzes
    List<QuizDto> findAllQuizzes();
    //method for safe new quiz
    Quiz saveQuiz(QuizDto quizDto);
}
