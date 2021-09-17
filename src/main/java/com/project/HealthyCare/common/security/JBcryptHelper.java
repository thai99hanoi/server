package com.project.HealthyCare.common.security;

import com.project.HealthyCare.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JBcryptHelper {
    @Autowired
    UserServiceImpl userService;

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

    public String[] generatePasswordByHashPlantextAndSalt(String plainTextPassword) {
        String salt = JBcryptHelper.randomSaltString();
        String passwordPlusSalt = plainTextPassword+salt;
        String passwordHashed = BCrypt.hashpw(passwordPlusSalt, BCrypt.gensalt(6));
        String [] passAndSalt = new String[2];
        passAndSalt[0] = passwordHashed;
        passAndSalt[1] = salt;
        return passAndSalt;
    }

    public Boolean checkBcryptPassword(String plaintTextPassword, String criperTextPassword) {
        return  BCrypt.checkpw(plaintTextPassword, criperTextPassword);
    }

    public String getHashString(String string) {
        return  BCrypt.hashpw(string, BCrypt.gensalt(6));
    }

    protected static  String randomSaltString() {
        Random random = new Random();
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 6) {
            int index = random.nextInt(62);
            salt.append(chars.charAt(index));
        }
        String saltString = salt.toString();
        return saltString;
    }

}
