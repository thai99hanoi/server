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
@Table(name = "province", schema = "healthcaresystem", catalog = "")
public class Province {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "name")
    private String name;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private Integer isActive;
}
