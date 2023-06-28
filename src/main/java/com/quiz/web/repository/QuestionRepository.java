package com.quiz.web.repository;

import com.quiz.web.models.Question;
import com.quiz.web.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findAllByQuiz(Quiz quiz);
}
