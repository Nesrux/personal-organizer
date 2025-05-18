package com.nesrux.organizer.infrastructure.api.models.task;

import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryInputDto;

public record TaskInputDto(
        String title,
        String description,
        Frequency frequency,
        CategoryInputDto categoryInputDto) {
    public Task toDomain() {

        return Task.create(title, description, frequency, categoryInputDto.toDomain());

    }
}
