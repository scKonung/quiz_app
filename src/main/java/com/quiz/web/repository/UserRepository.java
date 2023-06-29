package com.quiz.web.repository;

import com.quiz.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
