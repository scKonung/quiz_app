package com.quiz.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String photoUrl;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updateOn;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.REMOVE)
    private List<Question> questions;
    //many-to-many tables for quiz types
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "quiz_type",
            joinColumns = {@JoinColumn(name = "quiz_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id",referencedColumnName = "id")}
    )
    private List<Type> types = new ArrayList<>();

}
