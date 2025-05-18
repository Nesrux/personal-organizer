package com.nesrux.organizer.infrastructure.api.models.category;

import java.time.Instant;
import java.util.List;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Task;

public record CategoryOutput(
        String id,
        String name,
        Instant createdAt,
        Instant updatedAt) {

    public static CategoryOutput with(final Category category) {
        return new CategoryOutput(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getUpdatedAt());
    }
}