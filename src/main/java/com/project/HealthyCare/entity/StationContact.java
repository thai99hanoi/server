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
@Table(name = "station_contact", schema = "healthcaresystem", catalog = "")
public class StationContact {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "name")
    private String name;

    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "station_role_id")
    private Integer stationRoleId;

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;

}