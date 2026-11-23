package com.example.Users.repository;

import com.example.Users.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>
{
    Optional<UserCredential> findByAuthUserId(Long AuthUserID);

    boolean existsByAuthUserId(Long AuthUserID);
}
