package com.quiz.web.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class Question {
    @Id
    private long id;

    @NonNull
    private String title;

    @Nullable
    private String photoUrl;

    @NonNull
    @ElementCollection
    private List<String> answers = new ArrayList<>(4);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
