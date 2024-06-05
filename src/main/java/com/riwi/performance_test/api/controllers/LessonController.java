package com.riwi.performance_test.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.performance_test.api.dtos.request.LessonRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;
import com.riwi.performance_test.api.dtos.response.LessonResponse;
import com.riwi.performance_test.infraestructure.abstract_services.ILessonService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {

    private final ILessonService service;

    @Operation
    @PostMapping
        public ResponseEntity<LessonResponse> insert(
        @Validated @RequestBody LessonRequest request
    ){
        return  ResponseEntity.ok(this.service.create(request));
    }

    @Operation(summary = "Search a class by Id", description = "The id of the class to be searched for is needed to perform the search for it ")
    @GetMapping(path = "/{id}/multimedia")
    public ResponseEntity<LessonResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }

    @Operation(summary = "Disable a specific lesson.", description = "You must enter the id of the specific lesson you wish to disable.")
    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<LessonResponse> disable(
        @PathVariable Long id) {
    return ResponseEntity.ok(this.service.update(id));
    }

}
