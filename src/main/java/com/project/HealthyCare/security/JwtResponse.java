package com.project.HealthyCare.security;

import java.io.Serializable;


public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private String date;

    public JwtResponse(String jwttoken, String date) {
        this.token = jwttoken;
        this.date = date;
    }

    public String getToken() {
        return token;
    }
    public String getDate(){return  date;}
}

