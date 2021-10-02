package com.project.HealthyCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalUnitRepository extends JpaRepository<MedicalUnitRepository, Integer> {
}
