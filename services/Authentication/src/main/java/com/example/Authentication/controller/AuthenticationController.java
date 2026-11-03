package com.example.Authentication.controller;

import com.example.Authentication.dto.LoginRequest;
import com.example.Authentication.dto.LoginResponse;
import com.example.Authentication.dto.RegisterRequest;
import com.example.Authentication.service.AuthenticationService;
import com.example.Authentication.service.JWTService;
import com.example.Authentication.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;
    private final JWTService jwtService;


    public AuthenticationController(RegistrationService registrationService,
                                    AuthenticationService authenticationService,
                                    JWTService jwtService) {
        this.registrationService = registrationService;
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest)
    {
        registrationService.register(registerRequest.getEmail(),registerRequest.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        UserDetails userDetails =
                (UserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(userDetails);

        LoginResponse response =
                new LoginResponse(accessToken, "Bearer");

        return ResponseEntity.ok(response);
    }


    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails)
    {
        return ResponseEntity.ok(userDetails.getUsername());
    }


}
