package com.nesrux.organizer.infrastructure.api.models.category;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Input DTO containing the ID of a category")
public record CategoryIdInput(
        @Schema(
                description = "Unique identifier of the category",
                example = "9ecf5261ebff4842a2464ce05bdd317f")
        String id
) {
}
