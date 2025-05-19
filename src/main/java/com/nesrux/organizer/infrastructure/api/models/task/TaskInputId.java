package com.nesrux.organizer.infrastructure.api.models.task;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO containing the ID of a task")
public record TaskInputId(

        @Schema(description = "Unique identifier of the task", example = "6ba27475a3f4494db6e646fb877eb139")
        String id){}
