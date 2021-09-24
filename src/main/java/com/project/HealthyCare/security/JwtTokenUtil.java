package com.project.HealthyCare.security;

import java.io.Serializable;
import java.util.Date;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static final String SECRET_KEY = "11111111111111111111111111111111" ;

    @Autowired
    private Environment env;

    public String generateTokenLogin(String username) {
        String token =null;
        try {
            JWSSigner signer = new MACSigner(generateShareSecret());
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(env.getProperty("username"), username);
            builder.expirationTime(generateExpirationDate());
            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);
            token = signedJWT.serialize();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return token;
    }

    private Date generateExpirationDate() {
        int time = Integer.parseInt(String.valueOf(10)) * 60 * 1000;
        return new Date(System.currentTimeMillis() + time);
    }

    private JWTClaimsSet getClaimsFromToken(String token) {
        JWTClaimsSet claims = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(generateShareSecret());
            if(signedJWT.verify(verifier)) {
                claims = signedJWT.getJWTClaimsSet();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return claims;
    }

    private byte[] generateShareSecret() {
        byte[] shareSecret = new byte[20];
        shareSecret = SECRET_KEY.getBytes();
        return shareSecret;
    }

    public String getUserFromToken(String token) {
        String username =null;
        try {
            JWTClaimsSet claimsSet = getClaimsFromToken(token);
            username = claimsSet.getStringClaim(env.getProperty("username"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return username;
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public int validateTokenLogin(String token) {
        if(token == null || token.trim().length() == 0) {
            return 0;
        }
        String username = getUserFromToken(token);
        if( username == null || username.isEmpty()) {
            return 0;
        }
        if(isTokenExpired(token)) {
            return 0;
        }
        return 1;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration = null;
        JWTClaimsSet claimsSet = getClaimsFromToken(token);
        return expiration = claimsSet.getExpirationTime();

    }

}
