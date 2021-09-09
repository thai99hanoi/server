package com.project.HealthyCare.dao.service;

import com.project.HealthyCare.dao.entity.Role;
import com.project.HealthyCare.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.HealthyCare.common.base.BaseServiceImpl;
import com.project.HealthyCare.dao.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserDetailsService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = userRepository.findUserByUsername(username);
            if(user == null){
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), "$2a$16$AYSTH/JEPXPwqYBRswLq0emwmItvsQgf.dnaffXGJpvYML97bBoGe", new ArrayList<>());

        }
        catch (Exception ex){
            throw new UsernameNotFoundException("User not found" );
        }
    }

    public User getUserByUsername (String username ) {
        return userRepository.findUserByUsername(username);
    }

}
