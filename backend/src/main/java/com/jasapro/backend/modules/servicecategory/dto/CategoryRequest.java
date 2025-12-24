package com.jasapro.backend.modules.servicecategory.dto;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank(message = "Category name cannot be blank")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    private String iconUrl;

    // Constructors
    public CategoryRequest() {
    }

    public CategoryRequest(String name, String description, String iconUrl) {
        this.name = name;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CategoryRequest that = (CategoryRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(iconUrl, that.iconUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, iconUrl);
    }
}
