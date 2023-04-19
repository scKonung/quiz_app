package com.quiz.web.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="quiz")
//the quiz class
public class Quiz {
    @Id
    private long id;
    @NonNull
    private String title;
    private String photoUrl;
    @Nullable
    private String content;
    @CreationTimestamp
    private LocalDateTime createOn;
    @CreationTimestamp
    private  LocalDateTime updateOn;

    @ManyToMany
    @JoinTable(
            name = "quiz_category",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<Category>();
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

}
