package com.example.Users.entities;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "user_movie_credentials")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="auth_user_id",unique = true, nullable = false, updatable = false)
    private Long AuthUserId;

    @Column(unique = true)
    private String username;

    @Column(name="display_name",nullable = false)
    private String DisplayName;

    @Column
    private String bio;

    @ElementCollection
    @Column(name="favourite_genre")
    private List<String> FavouriteGenre;

    @Column(name="is_profile_public",nullable = true)
    private Boolean IsProfilePublic;

    @Column(name="created_at",nullable = false, updatable = false)
    private Instant CreatedAt;

    @Column(name="updated_at",nullable = false)
    private Instant UpdatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthUserId() {
        return AuthUserId;
    }

    public void setAuthUserId(Long authUserId) {
        AuthUserId = authUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getFavouriteGenre() {
        return FavouriteGenre;
    }

    public void setFavouriteGenre(List<String> favouriteGenre) {
        FavouriteGenre = favouriteGenre;
    }

    public Boolean getProfilePublic() {
        return IsProfilePublic;
    }

    public void setProfilePublic(Boolean profilePublic) {
        IsProfilePublic = profilePublic;
    }

    public Instant getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Instant createdAt) {
        CreatedAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        UpdatedAt = updatedAt;
    }
}
