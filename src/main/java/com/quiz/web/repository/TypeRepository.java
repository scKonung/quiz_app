package com.quiz.web.repository;

import com.quiz.web.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findTypeByName(String name);
}
