package com.riwi.performance_test.infraestructure.services;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.performance_test.api.dtos.request.LessonRequest;
import com.riwi.performance_test.api.dtos.response.LessonResponse;
import com.riwi.performance_test.domain.entities.LessonEntity;
import com.riwi.performance_test.domain.repositories.LessonRepository;
import com.riwi.performance_test.infraestructure.abstract_services.ILessonService;
import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;
import com.riwi.performance_test.infraestructure.helpers.mappers.LessonMapper;
import com.riwi.performance_test.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {
    
    private final ServiceHelper serviceHelper;

    private final LessonMapper lessonMapper;

    private final LessonRepository lessonRepository;

    @Override
    public LessonResponse create(LessonRequest request) {
        LessonEntity lesson = this.lessonMapper.requestToEntity(request);
        return this.lessonMapper.entityToResponse(this.lessonRepository.save(lesson));
    }

    @Override
    public LessonResponse get(Long id) {
        return this.lessonMapper.entityToResponse(this.serviceHelper.find(id, lessonRepository, "class"));
    }

    @Override
    public LessonResponse update(LessonRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<LessonResponse> getAll(int page, int size, SortType sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
