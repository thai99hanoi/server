package com.project.HealthyCare.dao.entity;

import com.project.HealthyCare.dao.entity.converter.IsActiveConverter;
import com.project.HealthyCare.dao.po.IsActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unit", schema = "healthcaresystem", catalog = "")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_Id")
    private Integer roleId;

    @Column(name = "station_Id")
    private Integer stationId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "identity_id")
    private String identityId;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;

}
