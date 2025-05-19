package com.nesrux.organizer.domain.models.category;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.utils.IdUtils;
import com.nesrux.organizer.domain.utils.InstantUtils;
import com.nesrux.organizer.domain.utils.StringUtils;

public class Category {
    private final String id;
    private String name;
    private final Instant createdAt;
    private Instant updatedAt;

    private Category(final String id,
                     final String name,
                     final Instant createdAt,
                     final Instant updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "id not be null");
        this.name = StringUtils.validate(name, "name");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt not be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt not be null");
    }

    public static Category create(
            final String name) {
        return new Category(IdUtils.uuid(), name, InstantUtils.now(), InstantUtils.now());
    }


    public static  Category with(final String id, final String name, final Instant createdAt, final Instant updatedAt) {
        return new Category(id, name, createdAt, updatedAt);
    }

    public Category update(final String name){
        this.name = StringUtils.validate(name, "name");
        this.updatedAt = InstantUtils.now();
        return this;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
