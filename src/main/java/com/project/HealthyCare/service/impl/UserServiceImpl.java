package com.project.HealthyCare.service.impl;

import com.project.HealthyCare.entity.User;
import com.project.HealthyCare.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.HealthyCare.repository.UserRepository;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
        try{
            User user = userRepository.findUserByUsername(username, password);
            if(user == null){
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), password, new ArrayList<>());

        }
        catch (Exception ex){
            throw new UsernameNotFoundException("User not found" );
        }
    }

    public User getUserByUsername (String username, String password ) {
        return userRepository.findUserByUsername(username, password);
    }
    public UserDetails findUserByUsername (String username ) {
        User user = userRepository.findByUsername(username);
        if(Objects.nonNull(user))
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
        return null;
    }
}
