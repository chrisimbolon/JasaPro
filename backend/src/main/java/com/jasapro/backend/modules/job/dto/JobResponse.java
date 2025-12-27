package com.jasapro.backend.modules.job.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jasapro.backend.modules.job.JobStatus;

public class JobResponse {

    private Long id;
    private Long userId;
    private Long serviceCategoryId;
    private String title;
    private String description;
    private String location;
    private BigDecimal budget;
    private JobStatus status;
    private LocalDateTime scheduledAt;
    private LocalDateTime createdAt;

    public JobResponse() {
    }

    public JobResponse(
            Long id,
            Long userId,
            Long serviceCategoryId,
            String title,
            String description,
            String location,
            BigDecimal budget,
            JobStatus status,
            LocalDateTime scheduledAt,
            LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.serviceCategoryId = serviceCategoryId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.budget = budget;
        this.status = status;
        this.scheduledAt = scheduledAt;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
