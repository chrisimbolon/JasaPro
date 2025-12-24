package com.jasapro.backend.modules.servicecategory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jasapro.backend.exception.BadRequestException;
import com.jasapro.backend.exception.ResourceNotFoundException;
import com.jasapro.backend.modules.servicecategory.dto.CategoryRequest;
import com.jasapro.backend.modules.servicecategory.dto.CategoryResponse;

@Service
public class ServiceCategoryService {

    private final ServiceCategoryRepository repository;

    public ServiceCategoryService(ServiceCategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Create a new service category
     */
    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {
        // Check if category with same name already exists
        if (repository.findByName(request.getName()).isPresent()) {
            throw new BadRequestException("Category already exists: " + request.getName());
        }

        // Create new ServiceCategory entity
        ServiceCategory category = new ServiceCategory(
                request.getName(),
                request.getDescription(),
                request.getIconUrl());

        // Save to database
        ServiceCategory saved = repository.save(category);

        // Convert entity to DTO and return
        return mapToResponse(saved);
    }

    /**
     * Get all active categories
     */
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories() {
        return repository.findByIsActiveTrue()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Get a single category by ID
     */
    @Transactional(readOnly = true)
    public CategoryResponse getCategoryById(Long id) {
        ServiceCategory category = findCategoryById(id);
        return mapToResponse(category);
    }

    /**
     * Update an existing category
     */
    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        ServiceCategory category = findCategoryById(id);

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setIconUrl(request.getIconUrl());

        ServiceCategory updated = repository.save(category);

        return mapToResponse(updated);
    }

    /**
     * Delete a category (soft delete)
     */
    @Transactional
    public void deleteCategory(Long id) {
        ServiceCategory category = findCategoryById(id);
        category.setIsActive(false);
        repository.save(category);
    }

    /**
     * Common helper to load category or throw
     */
    private ServiceCategory findCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    }

    /**
     * Map ServiceCategory entity to CategoryResponse DTO
     */
    private CategoryResponse mapToResponse(ServiceCategory category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setIconUrl(category.getIconUrl());
        response.setIsActive(category.getIsActive());
        response.setCreatedAt(category.getCreatedAt());
        response.setUpdatedAt(category.getUpdatedAt()); // if your entity has it
        return response;
    }
}
