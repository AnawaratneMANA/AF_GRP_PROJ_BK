package com.testing.demo.Model.Response;

import org.springframework.security.authentication.AuthenticationManager;

public class jwtTockenResponse {
    private final String jwt;

    public jwtTockenResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return this.jwt;
    }
}
