package com.nesrux.organizer.infrastructure.persistence.models;

import java.time.Instant;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskJpaEntity {

    @Id
    private String id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryJpaEntity category;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    protected TaskJpaEntity() {
    }

    private TaskJpaEntity(
            final String id,
            final String title,
            final String description,
            final Frequency frequency,
            final boolean active,
            final CategoryJpaEntity category,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.frequency = frequency;
        this.active = active;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

   public static TaskJpaEntity toEntity(final Task task, final CategoryJpaEntity categoryJpa) {
    return new TaskJpaEntity(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getFrequency(),
            task.isActive(),
            categoryJpa, // ← Categoria já convertida, evita loop
            task.getCreatedAt(),
            task.getUpdatedAt(),
            task.getDeletedAt()
    );
}

    public Task toDomain() {
        return Task.with(id, title, description, frequency, active, category.toDomain(), createdAt, updatedAt);

    }

    public Task toDomainWithoutCategoryLoop() {
        return Task.with(
                this.id,
                this.title,
                this.description,
                this.frequency,
                this.active,
                Category.with(
                        this.category.getId(),
                        this.category.getName(),
                        this.category.getCreatedAt(),
                        this.category.getUpdatedAt()
                ),
                this.createdAt,
                this.updatedAt
        );
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Frequency getFrequency() {
        return this.frequency;
    }

    public void setFrequency(final Frequency frequency) {
        this.frequency = frequency;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public CategoryJpaEntity getCategory() {
        return this.category;
    }

    public void setCategory(final CategoryJpaEntity category) {
        this.category = category;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(final Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(final Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

}
