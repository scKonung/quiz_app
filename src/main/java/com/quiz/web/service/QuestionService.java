package com.quiz.web.service;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.models.Question;

public interface QuestionService {
    Question saveQuestion(QuestionDto questionDto);
}
