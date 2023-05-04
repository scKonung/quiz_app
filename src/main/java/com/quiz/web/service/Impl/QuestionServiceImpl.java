package com.quiz.web.service.Impl;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.models.Question;
import com.quiz.web.models.Quiz;
import com.quiz.web.repository.QuestionRepository;
import com.quiz.web.repository.QuizRepository;
import com.quiz.web.service.QuestionService;
import com.quiz.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.quiz.web.mapper.QuestionMapper.mapToQuestion;
import static com.quiz.web.mapper.QuizMapper.mapToQuiz;

@Service
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository questionRepository;
    QuizRepository quizRepository;
    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public Question saveQuestion(QuestionDto questionDto) {
        return questionRepository.save(mapToQuestion(questionDto));
    }
}
