package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.SampleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleTypeRepository extends JpaRepository<SampleType, Integer> {
}
