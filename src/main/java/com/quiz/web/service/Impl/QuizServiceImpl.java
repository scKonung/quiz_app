package com.quiz.web.service.Impl;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.repository.QuizRepository;
import com.quiz.web.repository.TypeRepository;
import com.quiz.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.quiz.web.mapper.QuizMapper.mapToQuiz;
import static com.quiz.web.mapper.QuizMapper.mapToQuizDto;

@Service
public class QuizServiceImpl implements QuizService {
    //repository for quiz
    private QuizRepository quizRepository;
    //repository for roles
    private TypeRepository typeRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, TypeRepository typeRepository ) {
        this.quizRepository = quizRepository;
        this.typeRepository = typeRepository;
    }

    //method to find all quizzes fot actually in database
    @Override
    public List<QuizDto> findAllQuizzes() {
        //get from Quiz Repository all quizzes
        List<Quiz> quizzes = quizRepository.findAll();
        //return all quizzes in list wthis mapping to dto
        return quizzes.stream().map((quiz) -> mapToQuizDto(quiz)).collect(Collectors.toList());
    }

    @Override
    public Quiz saveQuiz(QuizDto quizDto) {
        //map quizDto to quiz
        Quiz quiz = mapToQuiz(quizDto);
        //return a quiz with save in quiz repository
        return quizRepository.save(quiz);
    }
}
