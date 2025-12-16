package com.jasapro.backend.common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    // Note: createdAt and updatedAt are handled in User.java with
    // @PrePersist/@PreUpdate
    // We don't define them here to avoid conflicts
}
