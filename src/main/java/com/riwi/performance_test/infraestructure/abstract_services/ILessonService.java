package com.riwi.performance_test.infraestructure.abstract_services;

import com.riwi.performance_test.api.dtos.request.LessonRequest;
import com.riwi.performance_test.api.dtos.response.LessonResponse;

public interface ILessonService extends CrudService<LessonRequest, LessonResponse, Long> {

}
