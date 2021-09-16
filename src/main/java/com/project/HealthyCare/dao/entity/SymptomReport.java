package com.project.HealthyCare.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "symptom_report", schema = "healthcaresystem", catalog = "")
public class SymptomReport {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_symptom")
    private Integer idSymptom;

//    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

//    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Time time;
}