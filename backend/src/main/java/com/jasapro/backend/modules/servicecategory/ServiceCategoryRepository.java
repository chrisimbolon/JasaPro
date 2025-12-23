package com.jasapro.backend.modules.servicecategory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCategoryRepository extends
        JpaRepository<ServiceCategory, Long> {

    /**
     * Find a category by its name
     * Used to check for duplicates before creating
     */
    Optional<ServiceCategory> findByName(String name);

    /**
     * Get all active categories (isActive = true)
     * Used for public listing
     */
    List<ServiceCategory> findByIsActiveTrue();
}
