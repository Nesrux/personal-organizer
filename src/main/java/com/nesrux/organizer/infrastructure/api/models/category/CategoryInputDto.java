package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;

public record CategoryInputDto(
        String name) {

    public Category toDomain() {
        return Category.create(name);
    }
}
