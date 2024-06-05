package com.riwi.performance_test.api.dtos.request;


import jakarta.validation.constraints.Email;
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
public class StudentRequest {
    @NotBlank(message = "The Student have to have a name")
    private String name;
    @NotBlank (message =  "Email is required")
    @Email (message = "The input is not an e-mail")
    private String email;
    @NotBlank(message = "The Lesson must have an active status")
    private boolean active;
    @NotNull(message = "The Class id cannot be empty")
    @Min(value = 1, message = "Id must be greater than zero")
    private Long classId;
}
