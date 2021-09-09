package com.project.HealthyCare.dao.entity;

import com.project.HealthyCare.dao.entity.converter.IsActiveConverter;
import com.project.HealthyCare.dao.po.IsActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role", schema = "healthcaresystem", catalog = "")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "description")
    private String description;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
