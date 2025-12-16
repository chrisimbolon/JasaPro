package com.jasapro.backend.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    public String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    public String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    public String password;

    // Constructors
    public UserRequest() {}

    public UserRequest(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
