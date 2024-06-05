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
public class MultimediaRequest {

    @NotBlank(message = "The Multimedia must have a type")
    private String type;
    @NotBlank(message = "The URL cannot be null")
    private String url;
    @NotBlank(message = "The Multimedia must have an active status")
    private boolean active;
    @NotNull(message = "The Lesson id cannot be empty")
    @Min(value = 1, message = "Id must be greater than zero")
    private Long idLesson;
}
