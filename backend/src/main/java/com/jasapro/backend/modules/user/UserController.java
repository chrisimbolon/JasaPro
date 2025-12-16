package com.jasapro.backend.modules.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasapro.backend.common.ApiResponse;
import com.jasapro.backend.modules.user.dto.UserRequest;
import com.jasapro.backend.modules.user.dto.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * POST /api/users/register
     * Register a new user
     * 
     * @param request validated UserRequest DTO
     * @return ResponseEntity with ApiResponse containing UserResponse
     */
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(
            @Valid @RequestBody UserRequest request) {

        UserResponse userResponse = userService.registerUser(request);

        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.success = true;
        response.message = "User registered successfully";
        response.data = userResponse;

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * GET /api/users/{id}
     * Get user by ID
     * 
     * @param id user ID
     * @return ResponseEntity with ApiResponse containing UserResponse
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);

        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.success = true;
        response.message = "User retrieved successfully";
        response.data = userResponse;

        return ResponseEntity.ok(response);
    }
}
