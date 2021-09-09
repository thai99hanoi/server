package com.project.HealthyCare.dao.entity;

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
@Table(name = "vaccine", schema = "healthcaresystem", catalog = "")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "vaccine_id")
    private Integer vaccineId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
