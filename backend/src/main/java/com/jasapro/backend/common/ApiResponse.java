package com.jasapro.backend.common;

/**
 * Generic API response wrapper for all endpoints
 * Ensures consistent response format across the application
 */
public class ApiResponse<T> {

    public boolean success;
    public String message;
    public T data;

    // Constructors
    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Static helpers for quick response creation
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
