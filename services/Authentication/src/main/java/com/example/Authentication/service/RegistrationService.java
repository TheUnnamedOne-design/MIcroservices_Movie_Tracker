package com.example.Authentication.service;

import com.example.Authentication.entities.UserCredential;
import com.example.Authentication.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(
            UserCredentialRepository userCredentialRepository,
            PasswordEncoder passwordEncoder)
    {
        this.userCredentialRepository=userCredentialRepository;
        this.passwordEncoder=passwordEncoder;
    }


    public UserCredential register(String email, String rawPassword)
    {
        if(userCredentialRepository.existsByEmail((email)))
        {
            throw new IllegalArgumentException("An account with this email already exists!");
        }

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(email);
        userCredential.setPasswordHash(passwordEncoder.encode(rawPassword));
        userCredential.setRoles("ROLE_USER");

        return userCredentialRepository.save(userCredential);


    }

}
