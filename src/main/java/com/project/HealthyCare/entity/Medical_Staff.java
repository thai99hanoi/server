package com.project.HealthyCare.entity;

import com.project.HealthyCare.entity.converter.IsActiveConverter;
import com.project.HealthyCare.po.IsActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_staff", schema = "healthcaresystem", catalog = "")
public class Medical_Staff {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "medical_staff_id")
    private Integer medicalStaffId;

    @Column(name = "name")
    private String name;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "province_id")
    private Integer provinceId;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
