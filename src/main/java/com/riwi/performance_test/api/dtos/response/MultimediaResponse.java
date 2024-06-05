package com.riwi.performance_test.api.dtos.response;

import com.riwi.performance_test.utils.enums.TypeMultimedia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaResponse {
    private Long id;
    private TypeMultimedia type;
    private String url;
    private boolean active;
}
