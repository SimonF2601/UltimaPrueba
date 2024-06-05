package com.riwi.performance_test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.performance_test.domain.entities.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {

}
