package com.example.Authentication.service;

import com.example.Authentication.entities.UserCredential;
import com.example.Authentication.repository.UserCredentialRepository;
import com.example.Authentication.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserCredentialRepository userCredentialRepository;

    public CustomUserDetailService(UserCredentialRepository userCredentialRepository)
    {
        this.userCredentialRepository=userCredentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        UserCredential userCredential= userCredentialRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found with email "+email
                        )
                );
        return new CustomUserDetails(userCredential);
    }

}
