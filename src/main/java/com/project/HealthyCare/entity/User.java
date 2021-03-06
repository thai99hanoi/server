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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "healthcaresystem")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "identity_card")
    private String identityCard;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

//    @Convert(converter = IsActiveConverter.class)
    @Column(name = "is_active" , precision = 1, scale = 0)
    private Integer isActive;

//    @Convert(converter = IsOnlineConverter.class)
    @Column(name = "is_online" , precision = 1, scale = 0)
    private Integer isOnline;
}
