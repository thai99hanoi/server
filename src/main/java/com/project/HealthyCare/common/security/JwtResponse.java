package com.project.HealthyCare.common.security;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private Date date;

    public JwtResponse(String jwttoken, Date date) {
        this.token = jwttoken;
        this.date = date;
    }

    public String getToken() {
        return token;
    }
    public Date getDate(){return  date;}
}

