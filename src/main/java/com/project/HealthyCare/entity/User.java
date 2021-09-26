package com.project.HealthyCare.entity;

import com.project.HealthyCare.entity.converter.IsActiveConverter;
import com.project.HealthyCare.entity.converter.IsOnlineConverter;
import com.project.HealthyCare.po.IsActive;
import com.project.HealthyCare.po.IsOnline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "medical_staff_Id")
    private Integer medicalStaffId;

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

    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private IsActive isActive;

    @Convert(converter = IsOnlineConverter.class)
    @Column(name = "is_online" , precision = 1, scale = 0)
    private IsOnline isOnline;

}
