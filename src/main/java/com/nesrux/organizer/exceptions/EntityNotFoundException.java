package com.nesrux.organizer.exceptions;

public class EntityNotFoundException extends NoStacktraceException {

    public EntityNotFoundException(final String id) {
        super(String.format("Entity with id %s not found", id));
    }

}
