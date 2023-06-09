package com.quiz.web.service;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.models.Type;

import java.util.List;

public interface QuizService {
    //method for find all quizzes
    List<QuizDto> findAll();
    //method for safe new quiz
    void save(QuizDto quizDto);
    //method for find all
    // types of quizzes
    List<Type> findAllTypes();
    //method for find information about quiz by id
    QuizDto findById(long id);
    //update method
    void update(QuizDto quizDto);
    //delete method
    void delete(long id);

    //seacrh object by name
    List<QuizDto> searchByName(String query);
}
