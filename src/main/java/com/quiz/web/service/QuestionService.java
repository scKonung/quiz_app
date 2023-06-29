package com.quiz.web.service;

import com.quiz.web.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    //method for get all questions by the quiz
    List<QuestionDto> getAllByQuizId(long quizId);

    //method for creating new questions
    void create(long quizId, QuestionDto questionDto);

    //get question by id
    QuestionDto findById(long id);

    //update method
    void update(QuestionDto questionDto , long quizId);

    //delete method
    void delete(long id);

}
