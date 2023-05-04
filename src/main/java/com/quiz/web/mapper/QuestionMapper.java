package com.quiz.web.mapper;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Question;

public class QuestionMapper {
    public static Question mapToQuestion(QuestionDto questionDto) {
       return Question.builder()
                .id(questionDto.getId())
                .title(questionDto.getTitle())
                .quiz(questionDto.getQuiz())
                .build();
    }

    public static QuestionDto mapToQuestionDto(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .quiz(question.getQuiz())
                .build();
    }
}
