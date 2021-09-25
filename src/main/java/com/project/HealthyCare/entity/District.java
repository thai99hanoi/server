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
@Table(name = "district", schema = "healthcaresystem", catalog = "")
public class District {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "name")
    private String name;

    @Column(name = "province_Id")
    private Integer provinceId;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
