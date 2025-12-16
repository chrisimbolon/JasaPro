package com.jasapro.backend.modules.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jasapro.backend.exception.BadRequestException;
import com.jasapro.backend.modules.user.dto.UserRequest;
import com.jasapro.backend.modules.user.dto.UserResponse;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection (best practice)
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Register a new user
     * 
     * @param request UserRequest DTO with fullName, email, password
     * @return UserResponse DTO with user details (no password)
     * @throws BadRequestException if email already exists
     */
    @Transactional
    public UserResponse registerUser(UserRequest request) {
        // Check if email already exists
        if (userRepository.existsByEmail(request.email)) {
            throw new BadRequestException("Email already registered: " + request.email);
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(request.password);

        // Create new user entity
        User user = new User(request.fullName, request.email, hashedPassword);

        // Save to database
        User savedUser = userRepository.save(user);

        // Map entity to response DTO (no password exposed)
        return mapToResponse(savedUser);
    }

    /**
     * Get user by ID
     * 
     * @param id User ID
     * @return UserResponse DTO
     * @throws BadRequestException if user not found
     */
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found with ID: " + id));
        return mapToResponse(user);
    }

    /**
     * Map User entity to UserResponse DTO
     */
    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.id = user.getId();
        response.fullName = user.getFullName();
        response.email = user.getEmail();
        response.isActive = user.getIsActive();
        response.createdAt = user.getCreatedAt();
        return response;
    }
}
