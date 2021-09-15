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
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import com.project.HealthyCare.common.security.JwtTokenUtil;
import com.project.HealthyCare.dao.service.impl.UserServiceImpl;

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
            //Lấy user
            User user = userDetailsService.getUserByUsername(username, planTextPassword);
            if(user != null) {
                //Công chuỗi plantext và hash
                String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
                boolean valuate = BCrypt.checkpw(user.getPassword(), hash);
                if (valuate) {
                    final String token = jwtTokenUtil.generateTokenLogin(user.getUsername(), user.getPassword());
                    return ResponseEntity.ok(new JwtResponse(token, jwtTokenUtil.getExpirationDateFromToken(token)));
                } else {
                    return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error in createAuthenticationToken Controller");
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
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
