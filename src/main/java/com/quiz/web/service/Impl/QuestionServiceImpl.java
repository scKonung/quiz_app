package com.quiz.web.service.Impl;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.errors.QuizNotFoundException;
import com.quiz.web.models.Question;
import com.quiz.web.models.Quiz;
import com.quiz.web.repository.QuestionRepository;
import com.quiz.web.repository.QuizRepository;
import com.quiz.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.quiz.web.mapper.Mapper.mapToModel;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }


    @Override
    public void create(long quizId, QuestionDto questionDto) {
        Question question = mapToModel(questionDto);
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            question.setQuiz(quiz.get());
            questionRepository.save(question);
        } else
            throw new QuizNotFoundException(quizId);
    }
}
