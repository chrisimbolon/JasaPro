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

    // Constructor injection
    public ServiceCategoryService(ServiceCategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Create a new service category
     * 
     * @param request: CategoryRequest with name, description, iconUrl
     * @return: CategoryResponse with created category data
     * @throws BadRequestException if category name already exists
     */
    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {
        // Check if category with same name already exists
        if (repository.findByName(request.name).isPresent()) {
            throw new BadRequestException("Category already exists: " + request.name);
        }

        // Create new ServiceCategory entity
        ServiceCategory category = new ServiceCategory(
                request.name,
                request.description,
                request.iconUrl);

        // Save to database (Hibernate handles INSERT)
        ServiceCategory saved = repository.save(category);

        // Convert entity to DTO and return
        return mapToResponse(saved);
    }

    /**
     * Get all active categories
     * 
     * @return: List of CategoryResponse DTOs
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
     * 
     * @param id: Category ID
     * @return: CategoryResponse
     * @throws ResourceNotFoundException if category not found
     */
    @Transactional(readOnly = true)
    public CategoryResponse getCategoryById(Long id) {
        ServiceCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
        return mapToResponse(category);
    }

    /**
     * Update an existing category
     * 
     * @param id:      Category ID to update
     * @param request: Updated category data
     * @return: Updated CategoryResponse
     * @throws ResourceNotFoundException if category not found
     */
    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        ServiceCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        // Update fields
        category.setName(request.name);
        category.setDescription(request.description);
        category.setIconUrl(request.iconUrl);

        // Save changes (Hibernate handles UPDATE + @PreUpdate fires)
        ServiceCategory updated = repository.save(category);

        return mapToResponse(updated);
    }

    /**
     * Delete a category (soft delete)
     * Sets isActive to false instead of removing from database
     * 
     * @param id: Category ID to delete
     * @throws ResourceNotFoundException if category not found
     */
    @Transactional
    public void deleteCategory(Long id) {
        ServiceCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        // Soft delete: mark as inactive
        category.setIsActive(false);

        // Save the change
        repository.save(category);
    }

    /**
     * Map ServiceCategory entity to CategoryResponse DTO
     * Private utility method
     */
    private CategoryResponse mapToResponse(ServiceCategory category) {
        CategoryResponse response = new CategoryResponse();
        response.id = category.getId();
        response.name = category.getName();
        response.description = category.getDescription();
        response.iconUrl = category.getIconUrl();
        response.isActive = category.getIsActive();
        response.createdAt = category.getCreatedAt();
        return response;
    }
}
