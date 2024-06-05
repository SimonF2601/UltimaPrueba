package com.riwi.performance_test.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @Builder.Default
    private List<StudentEntity> students = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "classId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @Builder.Default
    private List<LessonEntity> lessons = new ArrayList<>();
}
