package com.project.HealthyCare.entity;

import com.project.HealthyCare.entity.converter.IsActiveConverter;
import com.project.HealthyCare.po.IsActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "daily_report", schema = "healthcaresystem", catalog = "")
public class DailyReport {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "daily_report_id")
    private Integer dailyReportId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Timestamp time;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "oxygen")
    private Double oxygen;

    @Column(name = "symptom_Id")
    private Integer symptomId;

    @Column(name = "comment")
    private String comment;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;
}
