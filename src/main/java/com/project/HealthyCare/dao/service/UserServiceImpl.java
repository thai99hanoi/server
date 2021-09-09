package com.project.HealthyCare.dao.service;

import com.project.HealthyCare.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.HealthyCare.common.base.BaseServiceImpl;
import com.project.HealthyCare.dao.repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserDetailsService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    new ArrayList<>());
        }
    }
}
