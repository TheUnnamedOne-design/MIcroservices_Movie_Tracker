package com.example.Authentication.security;

import com.example.Authentication.entities.UserCredential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final UserCredential userCredential;

    public CustomUserDetails(UserCredential userCredential)
    {
        this.userCredential=userCredential;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(new SimpleGrantedAuthority(userCredential.getRoles()));
    }

    @Override
    public String getPassword()
    {
        return userCredential.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return userCredential.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userCredential.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userCredential.isEnabled();
    }
}
