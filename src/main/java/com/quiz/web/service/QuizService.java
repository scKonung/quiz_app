package com.quiz.web.service;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.models.Type;

import java.util.List;

public interface QuizService {
    //method for find all quizzes
    List<QuizDto> findAllQuizzes();
    //method for safe new quiz
    Quiz saveQuiz(QuizDto quizDto);
    //method for find all types of quizzes
    List<Type> findAllTypes();
}
