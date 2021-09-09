package com.project.HealthyCare.dao.endpoint;

import com.project.HealthyCare.common.security.JBcryptHelper;
import com.project.HealthyCare.common.security.JwtRequest;
import com.project.HealthyCare.common.security.JwtResponse;
import com.project.HealthyCare.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import com.project.HealthyCare.common.security.JwtTokenUtil;
import com.project.HealthyCare.dao.service.UserServiceImpl;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private JBcryptHelper jBcryptHelper;


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
        try {
            //authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
            String username = authenticationRequest.getUsername();
            String planTextPassword = authenticationRequest.getPassword();

            //Lấy user từ username
            User user = userDetailsService.getUserByUsername(username);


            //Công chuỗi plantext và hash
            String hash = BCrypt.hashpw(planTextPassword, BCrypt.gensalt(12));
            boolean valuate = BCrypt.checkpw(planTextPassword, hash);
            if(valuate){
                final String token = jwtTokenUtil.generateTokenLogin(username);
                return ResponseEntity.ok(new JwtResponse(token));
            } else {
                return new ResponseEntity<>(true, HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error in createAuthenticationToken Controller");
            return new ResponseEntity<>(true, HttpStatus.CONFLICT);
        }


    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
