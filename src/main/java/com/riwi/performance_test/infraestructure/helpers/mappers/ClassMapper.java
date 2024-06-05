package com.riwi.performance_test.infraestructure.helpers.mappers;

import org.springframework.stereotype.Component;

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;
import com.riwi.performance_test.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClassMapper {

    public ClassResponse entityToResponse(ClassEntity entity){
        return ClassResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .description(entity.getDescription())
            .createdAt(entity.getCreatedAt())
            .active(entity.isActive())
            .build();
    }

    public ClassEntity requestToEntity(ClassRequest request){
        return ClassEntity
        .builder()
        .name(request.getName())
        .description(request.getDescription())
        .active(request.isActive())
        .build();
    }

}
