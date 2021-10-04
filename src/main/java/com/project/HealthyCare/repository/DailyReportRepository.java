package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {
}
