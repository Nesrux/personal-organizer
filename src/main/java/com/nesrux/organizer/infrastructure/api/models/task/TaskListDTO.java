package com.nesrux.organizer.infrastructure.api.models.task;

import java.time.Instant;

import com.nesrux.organizer.domain.models.task.Task;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Compact DTO used to represent a task in task listings")
public record TaskListDTO(
        @Schema(description = "Unique identifier of the task", example = "6ba27475a3f4494db6e646fb877eb139")
        String id,

        @Schema(description = "Title of the task", example = "Submit expense report")
        String title,

        @Schema(description = "Brief description of the task", example = "Submit the expense report for travel reimbursement")
        String description,

        @Schema(description = "Task frequency (e.g., daily, weekly, monthly)", example = "monthly")
        String frequency,

        @Schema(description = "Indicates if the task is currently active", example = "true")
        boolean active,

        @Schema(description = "Creation timestamp of the task", example = "2024-05-01T08:30:00Z")
        Instant createdAt,

        @Schema(description = "Last update timestamp of the task", example = "2024-05-10T14:00:00Z")
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
