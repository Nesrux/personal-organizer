package com.nesrux.organizer.infrastructure.api.models.task;

import java.time.Instant;

import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryResponse;

public record TaskOutputDto(
        String id,
        String title,
        String description,
        Frequency frequency,

        boolean active,
        CategoryResponse category,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt) {

    public static TaskOutputDto with(final Task task) {
        return new TaskOutputDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getFrequency(),
                task.isActive(),
                CategoryResponse.fromDomain(task.getCategory()),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getDeletedAt());
    }

}
