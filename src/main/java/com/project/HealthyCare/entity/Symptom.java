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
@Table(name = "symptom", schema = "healthcaresystem", catalog = "")
public class Symptom {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "symptom_Id")
    private Integer symptomId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
