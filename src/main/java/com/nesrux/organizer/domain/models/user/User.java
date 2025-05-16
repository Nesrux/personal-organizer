package com.nesrux.organizer.domain.models.user;

import java.time.Instant;
import java.util.Objects;

import com.nesrux.organizer.utils.IdUtils;
import com.nesrux.organizer.utils.InstantUtils;

public class User {

    private String id;
    private String nome;
    private String email;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(final String id, final String nome, final String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.active = true;
        this.createdAt = InstantUtils.now();
        this.updatedAt = InstantUtils.now();
    }

    public static User create(final String nome, final String email) {
        return new User(IdUtils.uuid(), nome, email);
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
