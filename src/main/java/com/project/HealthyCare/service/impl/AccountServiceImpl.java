package com.project.HealthyCare.service.impl;

import com.project.HealthyCare.common.base.BaseServiceImpl;
import com.project.HealthyCare.common.base.ServiceResponse;
import com.project.HealthyCare.common.constant.MessageCode;
import com.project.HealthyCare.entity.User;
import com.project.HealthyCare.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<User, UserRepository> {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public AccountServiceImpl(UserRepository repository) {
        super(repository);
    }

    public ServiceResponse<User> getCurrentUser() {
        try {
            String currentUserName = "";
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                currentUserName = authentication.getName();
                System.out.println(currentUserName);
            }
            currentUserName  =  SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info("username: ", currentUserName);
            User user = null;
            user = userRepository.findByUsername(currentUserName);
            return new ServiceResponse<User>(MessageCode.SUCCESS, user);
        } catch (Exception e) {
            logger.error("Exception: ", e);
            return new ServiceResponse<User>(MessageCode.FAILED, null);
        }
    }
}
