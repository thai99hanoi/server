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

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    @ManyToOne
    @JoinColumn(name = "medicine_report_id")
    private MedicineReport medicineReport;

    @ManyToOne
    @JoinColumn(name = "sympton_report_id")
    private SymptomReport symptonReport;

}
