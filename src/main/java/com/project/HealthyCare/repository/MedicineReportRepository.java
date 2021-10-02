package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.MedicineReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineReportRepository extends JpaRepository<MedicineReport, Integer> {
}
