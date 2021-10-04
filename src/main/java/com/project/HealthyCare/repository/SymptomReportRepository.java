package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.SymptomReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomReportRepository extends JpaRepository<SymptomReport, Integer> {
}
