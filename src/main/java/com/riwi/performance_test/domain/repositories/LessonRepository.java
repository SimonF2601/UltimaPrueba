package com.riwi.performance_test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.performance_test.domain.entities.LessonEntity;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity,Long>  {

}
