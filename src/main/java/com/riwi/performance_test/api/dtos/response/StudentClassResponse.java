package com.riwi.performance_test.api.dtos.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentClassResponse {
    private Long id;
    private String name;
    private String email;
    private boolean active;
    private ClassResponse classId;
}
