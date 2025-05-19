package com.nesrux.organizer.domain.models.task;

import java.time.Instant;
import java.util.Objects;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.utils.IdUtils;
import com.nesrux.organizer.domain.utils.InstantUtils;
import com.nesrux.organizer.domain.utils.StringUtils;

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
            final Category category,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "id not be null");
        this.title = StringUtils.validate(title, "title");
        this.description = StringUtils.validate(description, "description");
        this.category = Objects.requireNonNull(category, "category not be null");
        this.frequency = Objects.requireNonNull(frequency, "frequency not be null");
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Task create(
            final String title,
            final String description,
            final Frequency frequency,
            final Category category) {
        return new Task(
                IdUtils.uuid(),
                title,
                description,
                frequency,
                true,
                category,
                InstantUtils.now(),
                InstantUtils.now());
    }

    public static Task with(
            final String id,
            final String title,
            final String description,
            final Frequency frequency,
            final boolean active,
            final Category category,
            final Instant createdAt,
            final Instant updatedAt) {
        return new Task(id, title, description, frequency, active, category, createdAt, updatedAt);
    }

    public Task update(
            final String title,
            final String description,
            final Frequency frequency) {
        setTitle(title);
        setDescription(description);
        this.frequency = Objects.requireNonNull(frequency, "frequency not be null");
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public void activate() {
        if (!this.active) {
            this.active = true;
            this.updatedAt = InstantUtils.now();
            this.deletedAt = null;
        }
    }

    public void deactivate() {
        if (this.active) {
            this.active = false;
            this.updatedAt = InstantUtils.now();
            this.deletedAt = InstantUtils.now();
        }
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

    public Category getCategory() {
        return this.category;
    }

    public boolean isActive() {
        return this.active;
    }

    private void setTitle(final String title) {
        this.title = StringUtils.validate(title, "title");
    }

    private void setDescription(final String description) {
        this.description = StringUtils.validate(description, "description");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
