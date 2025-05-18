package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;

import java.time.Instant;

public record CategoryResponse(
        String id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
    public static CategoryResponse fromDomain(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }
}
