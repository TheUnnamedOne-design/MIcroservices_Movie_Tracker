package com.example.Authentication.controller;

import com.example.Authentication.dto.RegisterRequest;
import com.example.Authentication.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final RegistrationService registrationService;

    public AuthenticationController(
            RegistrationService registrationService){
        this.registrationService=registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest)
    {
        registrationService.register(registerRequest.getEmail(),registerRequest.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }


}
