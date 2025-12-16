package com.jasapro.backend.modules.user.dto;

import java.time.LocalDateTime;

public class UserResponse {

    public Long id;
    public String fullName;
    public String email;
    public Boolean isActive;
    public LocalDateTime createdAt;

    // Constructors
    public UserResponse() {
    }

    public UserResponse(Long id, String fullName, String email, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }
}
