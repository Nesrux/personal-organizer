package com.nesrux.organizer.infrastructure.api.models.category;

import com.nesrux.organizer.domain.models.category.Category;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

public record CategoryResponse(
        @Schema(description = "Unique identifier of the category", example = "9ecf5261ebff4842a2464ce05bdd317f")
        String id,

        @Schema(description = "Name of the category", example = "Estudar")
        String name,

        @Schema(description = "Date and time when the category was created", example = "2024-04-20T10:15:30Z")
        Instant createdAt,

        @Schema(description = "Date and time when the category was last updated", example = "2024-05-15T09:45:00Z")
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
