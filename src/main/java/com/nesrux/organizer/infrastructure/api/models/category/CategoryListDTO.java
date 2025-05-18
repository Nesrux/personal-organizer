package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;

public record CategoryListDTO(
        String id,
        String name) {
    public static CategoryListDTO fromDomain(final Category category) {
        return new CategoryListDTO(
                category.getId(),
                category.getName());
    }
}
