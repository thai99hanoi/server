package com.project.HealthyCare.repository;

import com.project.HealthyCare.entity.MedicalUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalUnitRepository extends JpaRepository<MedicalUnit, Integer> {
}
