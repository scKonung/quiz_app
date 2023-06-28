package com.quiz.web.service.Impl;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.errors.QuestionNotFoundException;
import com.quiz.web.errors.QuizNotFoundException;
import com.quiz.web.mapper.Mapper;
import com.quiz.web.models.Question;
import com.quiz.web.models.Quiz;
import com.quiz.web.repository.QuestionRepository;
import com.quiz.web.repository.QuizRepository;
import com.quiz.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.quiz.web.mapper.Mapper.mapToDto;
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
    public List<QuestionDto> getAllByQuizId(long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
           List<Question> questions = questionRepository.findAllByQuiz(quiz.get());
           return questions.stream().map(Mapper::mapToDto).collect(Collectors.toList());
        }
        else throw new QuizNotFoundException(quizId);
    }

    @Override
    public void create(long quizId, QuestionDto questionDto) {
        Question question = mapToModel(questionDto);
        if (question.getRightAnswerIndex() == null)
            question.setRightAnswerIndex(0);
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            question.setQuiz(quiz.get());
            questionRepository.save(question);
        } else
            throw new QuizNotFoundException(quizId);
    }

    @Override
    public QuestionDto findById(long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent())
            return mapToDto(question.get());
        else
            throw new QuestionNotFoundException(id);
    }
}
