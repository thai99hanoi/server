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
@Table(name = "sample_type", schema = "healthcaresystem", catalog = "")
public class SampleType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "name")
    private String name;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
