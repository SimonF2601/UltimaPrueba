package com.riwi.performance_test.domain.entities;

import java.time.LocalDateTime;


import com.riwi.performance_test.utils.enums.TypeMultimedia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "multimedia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private TypeMultimedia type;
    @Column(nullable = false)
    private String url;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @Column(nullable = false)
    private LessonEntity lesson;


}
