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


    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public CategoryJpaEntity() {
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
        return Category.with(this.id, this.name, this.createdAt, this.updatedAt);
    }

    public static CategoryJpaEntity toEntity(final Category category) {

        return new CategoryJpaEntity(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getUpdatedAt());
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
