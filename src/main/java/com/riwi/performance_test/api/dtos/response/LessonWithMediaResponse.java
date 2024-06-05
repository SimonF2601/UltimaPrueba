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
public class LessonWithMediaResponse {
    private Long id;
    private String title;
    private String content;
    private boolean active;
    private List<MultimediaResponse> multimedia;

}
