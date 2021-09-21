package com.project.HealthyCare.controller;

import com.project.HealthyCare.common.base.ServiceResponse;
import com.project.HealthyCare.entity.User;
import com.project.HealthyCare.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private AccountServiceImpl userService;

    @GetMapping("/current-user")
    public ServiceResponse<User> getCurrentUser(){
        return userService.getCurrentUser();
    }

    @PostMapping("/update")
    public ServiceResponse<User> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/delete")
    public ServiceResponse<Boolean> deleteUser(@RequestParam("userId") int userId){
        return userService.deleteUser(userId);
    }

    @GetMapping("/users-online")
    public ServiceResponse<List<User>> getUserIsOnline (@RequestParam("userId") int userId){
        return  userService.getUserOnline(userId);
    }
}
