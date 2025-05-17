package com.nesrux.organizer.infrastructure.persistence.models;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.nesrux.organizer.domain.models.category.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryJpaEntity {

    @Id
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TaskJpaEntity> tasks;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected CategoryJpaEntity() {
    }

    private CategoryJpaEntity(
            final String id,
            final String name,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Category toDomain() {
        final var domainTasks = this.getTasks().stream()
                .map(TaskJpaEntity::toDomain)
                .collect(Collectors.toList());

        return Category.with(
                this.getId(),
                this.getName(),
                this.getCreatedAt(),
                this.getUpdatedAt(),
                domainTasks);

    }

    public static CategoryJpaEntity toEntity(final Category category) {
        final var categoryEntity = new CategoryJpaEntity(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getUpdatedAt());

        final var taskEntities = category.getTasks().stream()
                .map(TaskJpaEntity::toEntity)
                .collect(Collectors.toList());

        categoryEntity.setTasks(taskEntities);

        return categoryEntity;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskJpaEntity> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<TaskJpaEntity> tasks) {
        this.tasks = tasks;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}
