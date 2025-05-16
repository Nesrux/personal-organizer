package com.nesrux.organizer.domain.models.task;

public enum Frequency {
    UNIQUE("unique"),
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly");

    private String value;

    private Frequency(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
