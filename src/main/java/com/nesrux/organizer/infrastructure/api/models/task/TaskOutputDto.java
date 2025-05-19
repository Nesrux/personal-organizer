package com.nesrux.organizer.infrastructure.api.models.task;

import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Detailed DTO representing a single task with full information")

public record TaskOutputDto(
        @Schema(description = "Unique identifier of the task", example = "6ba27475a3f4494db6e646fb877eb139")
        String id,

        @Schema(description = "Title of the task", example = "Write blog post about Spring Boot")
        String title,

        @Schema(description = "Detailed description of the task", example = "Create a technical blog post explaining how to use Spring Boot with OpenAPI")
        String description,

        @Schema(description = "Frequency of task execution", example = "WEEKLY")
        Frequency frequency,

        @Schema(description = "Indicates if the task is currently active", example = "true")
        boolean active,

        @Schema(description = "Category to which this task belongs")
        CategoryResponse category,

        @Schema(description = "Date and time when the task was created", example = "2024-05-01T09:00:00Z")
        Instant createdAt,

        @Schema(description = "Date and time when the task was last updated", example = "2024-05-15T11:30:00Z")
        Instant updatedAt,

        @Schema(description = "Date and time when the task was deleted, if applicable", example = "2024-05-20T18:45:00Z")
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
