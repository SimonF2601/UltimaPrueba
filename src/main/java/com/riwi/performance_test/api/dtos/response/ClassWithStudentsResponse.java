package com.riwi.performance_test.api.dtos.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassWithStudentsResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private boolean active;
    private List<StudentResponse> students;
}
