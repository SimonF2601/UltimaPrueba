package com.riwi.performance_test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.performance_test.domain.entities.MultimediaEntity;

public interface MultimediaRepository extends JpaRepository<MultimediaEntity,Long> {

}
