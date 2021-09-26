package com.project.HealthyCare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info", schema = "healthcaresystem", catalog = "")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_info_id")
    private Integer userInfoId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "firstname")
    private String firstname;

    @Id
    @Column(name = "middle_name")
    private String middleName;

    @Id
    @Column(name = "lastname")
    private String lastname;

    @Id
    @Column(name = "address")
    private String address;

    @Id
    @Column(name = "province")
    private String province;

    @Id
    @Column(name = "district")
    private String district;

    @Id
    @Column(name = "position")
    private String position;

}
