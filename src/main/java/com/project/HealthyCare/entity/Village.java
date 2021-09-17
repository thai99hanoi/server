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
@Table(name = "village", schema = "healthcaresystem", catalog = "")
public class Village {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "name")
    private String name;

    @Column(name = "district_id")
    private Integer districtId;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
