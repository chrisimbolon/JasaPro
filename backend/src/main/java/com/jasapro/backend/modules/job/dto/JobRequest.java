package com.jasapro.backend.modules.job.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Service category ID is required")
    private Long serviceCategoryId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String location;

    private BigDecimal budget;

    private LocalDateTime scheduledAt;

    public JobRequest() {
    }

    public JobRequest(
            Long userId,
            Long serviceCategoryId,
            String title,
            String description,
            String location,
            BigDecimal budget,
            LocalDateTime scheduledAt) {
        this.userId = userId;
        this.serviceCategoryId = serviceCategoryId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.budget = budget;
        this.scheduledAt = scheduledAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(Long serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
}
