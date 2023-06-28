package com.quiz.web.service;

import com.quiz.web.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    //method for get all questions by the quiz
    List<QuestionDto> getAllByQuizId(long quizId);

    //method for creatng new questions
    void create(long quizId, QuestionDto questionDto);
}
