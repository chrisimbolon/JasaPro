package com.jasapro.backend.modules.provider.dto;

import java.time.LocalDateTime;

public class ProviderResponse {

    private Long id;
    private String fullName;
    private String email;
    private String specialization;
    private String bio;
    private Integer yearsOfExperience;
    private Boolean isActive;
    private Boolean isVerified;
    private LocalDateTime createdAt;

    public ProviderResponse() {
    }

    public ProviderResponse(
            Long id,
            String fullName,
            String email,
            String specialization,
            String bio,
            Integer yearsOfExperience,
            Boolean isActive,
            Boolean isVerified,
            LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.specialization = specialization;
        this.bio = bio;
        this.yearsOfExperience = yearsOfExperience;
        this.isActive = isActive;
        this.isVerified = isVerified;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
