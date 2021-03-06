package com.project.HealthyCare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "symptom_report", schema = "healthcaresystem")
public class SymptomReport {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "symptom_id", nullable = false)
    private Symptom symptom;

//    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

//    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Time time;
}
