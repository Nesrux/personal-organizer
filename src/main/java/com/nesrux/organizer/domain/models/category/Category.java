package com.nesrux.organizer.domain.models.category;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.utils.IdUtils;
import com.nesrux.organizer.utils.InstantUtils;
import com.nesrux.organizer.utils.StringUtils;

public class Category {
    private String id;
    private String name;
    private List<Task> tasks;
    private Instant createdAt;
    private Instant updatedAt;

    private Category(final String id, final String name, final Instant createdAt, final Instant updatedAt) {
        this.id = id;
        this.name = StringUtils.validate(name, "name");
        this.tasks = new ArrayList<>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Category create(final String name) {
        return new Category(IdUtils.uuid(), name, InstantUtils.now(), InstantUtils.now());
    }

    public Category addTask(final Task task) {
        tasks.add(task);
        this.updatedAt = InstantUtils.now();

        return this;
    }

    public Category addTasks(final List<Task> tasks) {
        tasks.addAll(tasks);
        this.updatedAt = InstantUtils.now();

        return this;
    }

    public Category deleteTask(final Task task) {
        this.tasks.remove(task);
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

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
