package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;
import io.swagger.v3.oas.annotations.media.Schema;

public record CategoryInputDto(
        @Schema(description = "Name of the category", example = "Estudar", maxLength = 255, minLength = 3)
        String name
) {

    public Category toDomain() {
        return Category.create(name);
    }
}
