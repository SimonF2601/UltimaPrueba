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

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;
import com.riwi.performance_test.infraestructure.abstract_services.IClassService;
import com.riwi.performance_test.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {

    private final IClassService service;
    @Operation(summary = "Create a new class", description = "The body of the ClassRequest in Json format is needed for the operation of creating a new class. ")
    @PostMapping
    public ResponseEntity<ClassResponse> insert(
        @Validated @RequestBody ClassRequest request
    ){
        return  ResponseEntity.ok(this.service.create(request));
    }

    @Operation(summary = "Search a class by Id", description = "The id of the class to be searched for is needed to perform the search for it ")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }
    
    @Operation(summary = "Get all Classes", description = "Brings all currently active classes")
    @GetMapping
    public ResponseEntity<Page<ClassResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) sortType = SortType.NONE;
        
        return ResponseEntity.ok(this.service.getAll(page -1, size, sortType));
    }
}
