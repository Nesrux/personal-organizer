package com.nesrux.organizer.domain.models.task;

import java.time.Instant;
import java.util.Objects;
import java.util.Locale.Category;

import com.nesrux.organizer.utils.IdUtils;
import com.nesrux.organizer.utils.InstantUtils;

public class Task {
    private String id;
    private String title;
    private String description;
    private Frequency frequency;
    private boolean active;
    private Category category;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Task(
            final String id,
            final String title,
            final String description,
            final Frequency frequency,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id not be null");
        this.title = Objects.requireNonNull(title, "title not be null");
        this.description = description;
        this.frequency = Objects.requireNonNull(frequency, "frequency not be null");
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Task create(final String title, final String description, final Frequency frequency) {
        return new Task(
                IdUtils.uuid(),
                title,
                description,
                frequency,
                false,
                InstantUtils.now(),
                InstantUtils.now());
    }

    public Task update(
            final String title,
            final String description,
            final Frequency frequency) {
        this.title = title;
        this.description = description;
        this.frequency = frequency;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public void actvate() {
        if (!this.active) {
            this.active = true;
            this.updatedAt = InstantUtils.now();
        }
    }

    public void deactivate() {
        if (this.active) {
            this.active = false;
            this.updatedAt = InstantUtils.now();
            this.deletedAt = InstantUtils.now();
        }
    }

    public Task changeFrequency(final Frequency frequency) {
        if (this.active != false) {
            this.frequency = frequency;
            this.updatedAt = InstantUtils.now();
        }
        return this;

    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Frequency getFrequency() {
        return this.frequency;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(this.id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
