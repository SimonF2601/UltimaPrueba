package com.riwi.performance_test.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
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
public class ClassRequest {
    @NotBlank(message = "The Class must have a name")
    private String name;
    @NotBlank(message = "The Class have to a descripcion")
    private String description;
    @NotBlank(message = "The Class must have an active status")
    private boolean active;
}
