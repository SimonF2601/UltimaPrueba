package com.riwi.performance_test.infraestructure.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.performance_test.api.dtos.request.MultimediaRequest;
import com.riwi.performance_test.api.dtos.response.MultimediaResponse;
import com.riwi.performance_test.domain.entities.MultimediaEntity;
import com.riwi.performance_test.domain.repositories.LessonRepository;
import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;
import com.riwi.performance_test.utils.enums.TypeMultimedia;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MultimediaMapper {
    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final LessonRepository lessonRepository;

    public MultimediaResponse entityToResponse(MultimediaEntity entity){
        return MultimediaResponse
        .builder()
        .id(entity.getId())
        .type(entity.getType())
        .url(entity.getUrl())
        .active(entity.isActive())
        .build();
    }

    public MultimediaEntity requestToEntity(MultimediaRequest request){
        return MultimediaEntity
        .builder()
        .type(TypeMultimedia.valueOf(request.getType()))
        .url(request.getUrl())
        .active(request.isActive())
        .lesson(this.serviceHelper.find(request.getIdLesson(), lessonRepository, "lesson"))
        .build();
    }
}
