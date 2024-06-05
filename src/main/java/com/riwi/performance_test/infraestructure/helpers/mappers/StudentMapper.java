package com.riwi.performance_test.infraestructure.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.performance_test.api.dtos.request.StudentRequest;
import com.riwi.performance_test.api.dtos.response.StudentClassResponse;
import com.riwi.performance_test.api.dtos.response.StudentResponse;
import com.riwi.performance_test.domain.entities.StudentEntity;
import com.riwi.performance_test.domain.repositories.ClassRepository;
import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StudentMapper {
     @Autowired
    private final ServiceHelper serviceHelper;
    
    @Autowired
    private final ClassMapper classMapper;

    @Autowired
    private final ClassRepository classRepository;
    

    public StudentResponse entityToResponse(StudentEntity entity){
        return StudentResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .email(entity.getEmail())
            .active(entity.isActive())
            .build();
    }

    
    public StudentClassResponse entityToResponseClass(StudentEntity entity){

        
        return StudentClassResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .email(entity.getEmail())
            .active(entity.isActive())
            .classId(this.classMapper.entityToResponse(entity.getClassId()))
            .build();
    }

    public StudentEntity requestToEntity(StudentRequest request){
        return StudentEntity
        .builder()
        .name(request.getName())
        .email(request.getEmail())
        .active(request.isActive())
        .classId(this.serviceHelper.find(request.getClassId(), classRepository, "Class"))
        .build();
    }
}
