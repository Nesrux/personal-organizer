package com.nesrux.organizer.infrastructure.handler;

import java.time.Instant;
import java.util.Map;

public class ErrorResponse {
    private final int status;
    private final String message;
    private final Instant timestamp;
    private final Map<String, String> validationErrors;

    public ErrorResponse(int status, String message, Instant timestamp) {
        this(status, message, timestamp, null);
    }

    public ErrorResponse(int status, String message, Instant timestamp, Map<String, String> validationErrors) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.validationErrors = validationErrors;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public Instant getTimestamp() { return timestamp; }
    public Map<String, String> getValidationErrors() { return validationErrors; }
}

