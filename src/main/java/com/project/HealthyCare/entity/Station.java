package com.project.HealthyCare.entity;

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
@Table(name = "station", schema = "healthcaresystem", catalog = "")
public class Station {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "name")
    private String name;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "province_id")
    private Integer provinceId;
}
