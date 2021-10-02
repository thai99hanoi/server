package com.project.HealthyCare.entity;

import com.project.HealthyCare.entity.converter.IsActiveConverter;
import com.project.HealthyCare.entity.converter.StatusConverter;
import com.project.HealthyCare.entity.converter.TestResultConverter;
import com.project.HealthyCare.po.IsActive;
import com.project.HealthyCare.po.Status;
import com.project.HealthyCare.po.TestResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "result", schema = "healthcaresystem", catalog = "")
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unitId;

    @Column(name = "number_test")
    private Integer numberTest;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Timestamp startDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "collect_date")
    private Timestamp collectDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "receive_date")
    private Timestamp receiveDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "test_date")
    private Timestamp testDate;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private SampleType sampleType;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status", precision = 1, scale = 0)
    private Status status;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "test_result")
    private TestResult testResult;

    @Column(name = "comment")
    private String comment;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private Integer isActive;
}
