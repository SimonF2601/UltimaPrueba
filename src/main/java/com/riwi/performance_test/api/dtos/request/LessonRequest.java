package com.riwi.performance_test.api.dtos.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRequest {
    @NotBlank(message = "The Lesson must have a title")
    private String title;
    @NotBlank(message = "The Lesson must have a content")
    private String content;
    @NotNull(message = "The Lesson must have an active status")
    private boolean active;
    @NotNull(message = "The Class id cannot be empty")
    @Min(value = 1, message = "Id must be greater than zero")
    private Long classId;
}
