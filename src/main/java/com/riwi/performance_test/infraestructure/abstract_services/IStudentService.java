package com.riwi.performance_test.infraestructure.abstract_services;

import com.riwi.performance_test.api.dtos.request.StudentRequest;
import com.riwi.performance_test.api.dtos.response.StudentResponse;

public interface IStudentService extends CrudService<StudentRequest, StudentResponse, Long> {
    public final String FIELD_BY_SORT = "name";
}
