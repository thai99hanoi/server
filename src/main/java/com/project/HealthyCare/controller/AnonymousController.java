package com.project.HealthyCare.controller;

import com.project.HealthyCare.common.base.ServiceResponse;
import com.project.HealthyCare.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anonymous")
public class AnonymousController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/check-username/{username}")
    public ServiceResponse<Boolean> checkUsername(@PathVariable("username") String username) {
        return accountService.checkUsername(username);
    };
}
