package com.nesrux.organizer.domain.models.task;

import com.nesrux.organizer.domain.exceptions.DomainException;

public enum Frequency {
    UNIQUE("unique"),
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly");

    private String value;

    private Frequency(final String value) {
        this.value = value;
    }

    public static Frequency fromString(String value) {
        return switch (value.toLowerCase()) {
            case "unique" -> UNIQUE;
            case "daily" -> DAILY;
            case "weekly" -> WEEKLY;
            case "monthly" -> MONTHLY;
            default -> throw new DomainException("Invalid frequency: " + value);
        };
    }

    public String getValue() {
        return value;
    }
}
