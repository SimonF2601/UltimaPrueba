package com.riwi.performance_test.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance_test.api.dtos.request.StudentRequest;
import com.riwi.performance_test.api.dtos.response.StudentResponse;
import com.riwi.performance_test.infraestructure.abstract_services.IStudentService;
import com.riwi.performance_test.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {
    
    private final IStudentService service;

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) sortType = SortType.NONE;
        
        return ResponseEntity.ok(this.service.getAll(page -1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> insert(
        @Validated @RequestBody StudentRequest request
    ){
        return  ResponseEntity.ok(this.service.create(request));
    }














}
