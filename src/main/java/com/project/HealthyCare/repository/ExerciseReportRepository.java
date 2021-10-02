package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.ExerciseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseReportRepository extends JpaRepository<ExerciseReport, Integer> {
}