package com.project.HealthyCare.controller;

import com.project.HealthyCare.common.base.ServiceResponse;
import com.project.HealthyCare.entity.User;
import com.project.HealthyCare.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private AccountServiceImpl userService;

    @GetMapping("/current-user")
    public ServiceResponse<User> getCurrentUser(){
        return userService.getCurrentUser();
    }
}
