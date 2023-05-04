package com.quiz.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="content")
    private String content;
    @Column(name="photoUrl")
    private String photoUrl;
    //many-to-many tables for quiz types
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "quiz_type",
            joinColumns = {@JoinColumn(name = "quiz_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id",referencedColumnName = "id")}
    )
    private List<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE)
    List<Question> questions = new ArrayList<>();
}
