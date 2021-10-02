package com.project.HealthyCare.entity;

import com.project.HealthyCare.entity.converter.IsActiveConverter;
import com.project.HealthyCare.po.IsActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_staff", schema = "healthcaresystem", catalog = "")
public class MedicalStaff {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "medical_staff_id")
    private Integer medicalStaffId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "medical_unit_id", referencedColumnName = "medical_unit_id")
    private MedicalUnit medicalUnit;

    @OneToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    private Hospital hospital;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private Integer isActive;
}
