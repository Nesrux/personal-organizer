package com.nesrux.organizer.infrastructure.api.models.task;

import java.time.Instant;

import com.nesrux.organizer.domain.models.task.Task;

public record TaskListDTO(
    String id,
    String title,
    String description,
    String frequency,
    boolean active,
    Instant createdAt,
    Instant updatedAt
) {
    public static TaskListDTO fromDomain(Task task) {
        return new TaskListDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getFrequency().name(),
            task.isActive(),
            task.getCreatedAt(),
            task.getUpdatedAt()
        );
    }
}
