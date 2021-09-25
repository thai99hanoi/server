package com.project.HealthyCare.entity;

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
@Table(name = "excercise_report", schema = "healthcaresystem", catalog = "")
public class ExcerciseReport {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

//    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

//    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Time time;
}
