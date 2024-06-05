package com.riwi.performance_test.infraestructure.helpers.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.request.LessonRequest;
import com.riwi.performance_test.api.dtos.response.LessonResponse;
import com.riwi.performance_test.api.dtos.response.LessonWithMediaResponse;
import com.riwi.performance_test.api.dtos.response.MultimediaResponse;
import com.riwi.performance_test.domain.entities.ClassEntity;
import com.riwi.performance_test.domain.entities.LessonEntity;
import com.riwi.performance_test.domain.repositories.ClassRepository;
import com.riwi.performance_test.domain.repositories.MultimediaRepository;
import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LessonMapper {

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final MultimediaMapper multimediaMapper;
    
        public LessonResponse entityToResponse(LessonEntity entity){
        return LessonResponse.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .content(entity.getContent())
            .active(entity.isActive())
            .build();
    }

    public LessonWithMediaResponse entityToResponseMedia(LessonEntity entity){
        List<MultimediaResponse> multimedias = entity.getMultimedia()
        .stream()
        .map(media -> this.multimediaMapper.entityToResponse(media))
        .collect(Collectors.toList());
       
        return LessonWithMediaResponse.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .content(entity.getContent())
            .active(entity.isActive())
            .multimedia(multimedias)
            .build();
    }

    public LessonEntity requestToEntity(LessonRequest request){
        return LessonEntity
        .builder()
        .title(request.getTitle())
        .content(request.getContent())
        .active(request.isActive())
        .classId(this.serviceHelper.find(request.getClassId(),classRepository,"class"))
        .build();
    }
}
