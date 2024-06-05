package com.riwi.performance_test.infraestructure.abstract_services;

import com.riwi.performance_test.api.dtos.request.ClassRequest;
import com.riwi.performance_test.api.dtos.response.ClassResponse;

public interface IClassService extends CrudService<ClassRequest, ClassResponse, Long> {

}
