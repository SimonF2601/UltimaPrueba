package com.riwi.performance_test.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;
import com.riwi.performance_test.infraestructure.abstract_services.IClassService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {

    private final IClassService service;
    
    @PostMapping
    public ResponseEntity<ClassResponse> insert(
        @Validated @RequestBody ClassRequest request
    ){
        return  ResponseEntity.ok(this.service.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }
}
