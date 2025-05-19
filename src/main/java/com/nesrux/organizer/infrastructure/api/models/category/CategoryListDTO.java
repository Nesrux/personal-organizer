package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;
import io.swagger.v3.oas.annotations.media.Schema;

public record CategoryListDTO(
        @Schema(description = "Unique identifier of the category", example = "9ecf5261ebff4842a2464ce05bdd317f")
        String id,
        @Schema(description = "Name of the category", example = "Estudar", maxLength = 255, minLength = 3)
        String name)
{
    public static CategoryListDTO fromDomain(final Category category) {
        return new CategoryListDTO(
                category.getId(),
                category.getName());
    }
}
