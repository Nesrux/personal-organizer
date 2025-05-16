package com.nesrux.organizer.domain.models.user;

import java.time.Instant;
import java.util.Objects;

import com.nesrux.organizer.domain.utils.InstantUtils;

public class User {

    private UserId id;
    private String nome;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(final UserId id, final String nome, final String email) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.createdAt = InstantUtils.now();
        this.updatedAt = InstantUtils.now();

    }

    public static User create(final String nome, final String email) {
        return new User(UserId.unique(), nome, email);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id.getValue();
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
