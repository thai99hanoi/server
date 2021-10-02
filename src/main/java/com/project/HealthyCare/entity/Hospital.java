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
@Table(name = "hospital", schema = "healthcaresystem", catalog = "")
public class Hospital {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "hospital_id")
    private Integer hospitalId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private Integer isActive;

}
