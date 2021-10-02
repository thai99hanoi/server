package com.project.HealthyCare.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String username;
    private String mail;
    private String phone;
    private String firstname;
    private String lastname;
    private String surname;
    private String avatar;
    private String isOnline;
    private String isActive;
    private String isDeleted;
}
