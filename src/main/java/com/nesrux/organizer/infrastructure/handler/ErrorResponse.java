package com.nesrux.organizer.infrastructure.handler;

import java.time.Instant;
import java.util.Map;

public class ErrorResponse {
    private int status;
    private String message;
    private Instant timestamp;
    private Map<String, String> validationErrors;

    public ErrorResponse(int status, String message, Instant timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorResponse(
            final int status,
            final String message,
            final Instant timestamp,
            final Map<String, String> validationErrors) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.validationErrors = validationErrors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }
}

