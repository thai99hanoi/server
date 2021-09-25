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
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl extends BaseServiceImpl<User, UserRepository> {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public AccountServiceImpl(UserRepository repository) {
        super(repository);
    }

    /**
     * @Description: get current user
     * @return
     */
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

    /**
     * @Description: check username is exist in database
     * @param username
     * @return
     */
    public ServiceResponse<Boolean> checkUsername(String username){
        Integer count = 0;
        try{
            count = userRepository.checkUsername(username);
            if(count > 0){
                return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
            } else {
                return new ServiceResponse<Boolean>(MessageCode.SUCCESS, true);
            }
        }catch (Exception ex){
            logger.error("Exception: ", ex);
            return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
        }
    }

    /**
     * @Description: update user
     * @param user
     * @return
     */
    public ServiceResponse<User> updateUser(User user){
        try {
            User userExist = userRepository.findByUsername(user.getUsername());
            if (userExist != null) {
                userExist.setEmail(user.getEmail());
                userExist.setPhone(user.getPhone());
                userRepository.save(userExist);
                return new ServiceResponse<User>(MessageCode.SUCCESS, userExist);
            } else {
                return new ServiceResponse<User>(MessageCode.FAILED, null);
            }
        } catch (Exception ex){
            logger.error("Error: " , ex);
            return new ServiceResponse<User>(MessageCode.FAILED, null);
        }
    }

    /**
     * @Description: delete user
     * @param userId
     * @return
     */
    public ServiceResponse<Boolean> deleteUser(int userId){
        try{
            userRepository.deleteUser(userId);
            return new ServiceResponse<Boolean>(MessageCode.SUCCESS, true);
        } catch (Exception ex){
            logger.error("Exception: ", ex);
            return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
        }
    }

    public ServiceResponse<List<User>> getUserOnline (int userId){
        try{
            List<User> usersOnline = userRepository.getUserOnline(userId);
            if(!usersOnline.isEmpty()) return new ServiceResponse<List<User>>(MessageCode.SUCCESS, usersOnline);
            else return new ServiceResponse<List<User>>(MessageCode.FAILED, null);
        } catch (Exception ex){
            logger.error("Exception: ", ex);
            return new ServiceResponse<List<User>>(MessageCode.FAILED, null);
        }
    }
}
