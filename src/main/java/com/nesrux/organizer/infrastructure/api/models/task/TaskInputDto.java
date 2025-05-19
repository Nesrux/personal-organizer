package com.nesrux.organizer.infrastructure.api.models.task;

import io.swagger.v3.oas.annotations.media.Schema;

public record TaskInputDto(
        @Schema(description = "Title of the task", example = "Finish project report")
        String title,

        @Schema(description = "Detailed description of the task", example = "Complete the final draft of the quarterly report and submit it by email")
        String description,

        @Schema(description = "Frequency of the task execution (daily, weekly, monthly, unique)", example = "weekly")
        String frequency,

        @Schema(description = "ID of the category to which this task belongs", example = "9ecf5261ebff4842a2464ce05bdd317f")
        String categoryId
) {

}
