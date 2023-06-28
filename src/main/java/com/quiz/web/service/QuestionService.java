package com.quiz.web.service;

import com.quiz.web.dto.QuestionDto;

public interface QuestionService {
    void create(long quizId, QuestionDto questionDto);
}
