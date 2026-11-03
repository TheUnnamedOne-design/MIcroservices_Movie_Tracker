package com.example.Authentication.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            AuthenticationManager authenticationManager
    )
    {
        this.authenticationManager=authenticationManager;
    }

    public Authentication authenticate(String email, String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(email,password);

        return authenticationManager.authenticate(authenticationToken);
    }

}
