package com.nesrux.organizer.infrastructure.api.models.category;

import java.time.Instant;
import java.util.List;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Task;
import io.swagger.v3.oas.annotations.media.Schema;

public record CategoryOutput(
        @Schema(description = "Unique identifier of the category", example = "9ecf5261ebff4842a2464ce05bdd317f")
        String id,

        @Schema(description = "Name of the category", example = "Estudar")
        String name,

        @Schema(description = "Timestamp when the category was created", example = "2024-05-01T12:00:00Z")
        Instant createdAt,

        @Schema(description = "Timestamp when the category was last updated", example = "2024-05-10T15:30:00Z")
        Instant updatedAt

        ) {

    public static CategoryOutput with(final Category category) {
        return new CategoryOutput(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getUpdatedAt());
    }
}