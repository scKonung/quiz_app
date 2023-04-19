package com.quiz.web.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
//class with information about category for quiz
public class Category {
    @Id
    private long id;

    @NonNull
    private String name;

    @Nullable
    private String content;

    @ManyToMany(mappedBy = "categories")
    List<Quiz> quizzes = new ArrayList<>();

}
