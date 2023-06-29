package com.quiz.web.repository;

import com.quiz.web.models.Quiz;
import com.quiz.web.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    @Query("SELECT q FROM Quiz q WHERE q.name LIKE CONCAT('%',:query,'%') ")
    List<Quiz> searchQuizByName(String query);
}
