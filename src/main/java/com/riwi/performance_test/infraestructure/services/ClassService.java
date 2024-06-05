package com.riwi.performance_test.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.request.StudentRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;
import com.riwi.performance_test.api.dtos.response.StudentResponse;
import com.riwi.performance_test.domain.entities.ClassEntity;
import com.riwi.performance_test.domain.entities.StudentEntity;
import com.riwi.performance_test.domain.repositories.ClassRepository;
import com.riwi.performance_test.domain.repositories.StudentRepository;
import com.riwi.performance_test.infraestructure.abstract_services.IClassService;
import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;
import com.riwi.performance_test.infraestructure.helpers.mappers.ClassMapper;
import com.riwi.performance_test.infraestructure.helpers.mappers.StudentMapper;
import com.riwi.performance_test.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{

    private final IClassService service;

    @Autowired
    private final ClassMapper classMapper;
    @Autowired
    private final ClassRepository classRepository;
    @Autowired
    private final ServiceHelper serviceHelper;

    @Override
    public ClassResponse create(ClassRequest request) {
        ClassEntity objClass = this.classMapper.requestToEntity(request);
        return this.classMapper.entityToResponse(this.classRepository.save(objClass));
    }

    @Override
    public ClassResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ClassResponse update(ClassRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size, SortType sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
