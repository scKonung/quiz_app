package com.quiz.web.service.Impl;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.errors.QuizNotFoundException;
import com.quiz.web.mapper.Mapper;
import com.quiz.web.models.Quiz;
import com.quiz.web.models.Type;
import com.quiz.web.repository.QuizRepository;
import com.quiz.web.repository.TypeRepository;
import com.quiz.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.quiz.web.mapper.Mapper.mapToModel;
import static com.quiz.web.mapper.Mapper.mapToDto;

@Service
public class QuizServiceImpl implements QuizService {
    //repository for quiz
    private final QuizRepository quizRepository;
    //repository for roles
    private final TypeRepository typeRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, TypeRepository typeRepository ) {
        this.quizRepository = quizRepository;
        this.typeRepository = typeRepository;
    }

    //method to find all quizzes fot actually in database
    @Override
    public List<QuizDto> findAll() {
        //get from Quiz Repository all quizzes
        List<Quiz> quizzes = quizRepository.findAll();
        //return all quizzes in list this mapping to dto
        return quizzes.stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    //method to save a created quiz in database
    @Override
    public void save(QuizDto quizDto) {
        Quiz quiz = mapToModel(quizDto);
        if (quiz.getPhotoUrl().isEmpty())
            quiz.setPhotoUrl("https://img.freepik.com/free-vector/quiz-word-concept_23-2147844150.jpg?w=2000");
        //map a dto to database format and save int repository
        quizRepository.save(quiz);
    }
    //method for find all types of quizzes in database
    @Override
    public List<Type> findAllTypes() {
        //return all types from type repository
        return typeRepository.findAll();
    }
    //implementation of method fo find a quiz by id
    @Override
    public QuizDto findById(long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (quiz.isPresent())
            return mapToDto(quiz.get());
        else
            throw new QuizNotFoundException(id);
    }

    @Override
    public void update(QuizDto quizDto) {
        Quiz quiz = mapToModel(quizDto);
        quizRepository.save(quiz);

    }

    @Override
    public void delete(long id) {
        quizRepository.deleteById(id);
    }
}
