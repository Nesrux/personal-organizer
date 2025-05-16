package com.nesrux.organizer.domain.models.user;

import java.util.Objects;

import com.nesrux.organizer.domain.models.Identifier;
import com.nesrux.organizer.domain.utils.IdUtils;

public class UserId extends Identifier {
    private final String value;

    private UserId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static UserId unique() {
        return UserId.from(IdUtils.uuid());
    }

    public static UserId from(final String AnId) {
        return new UserId(AnId);
    }

}
