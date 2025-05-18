package com.nesrux.organizer.domain.exceptions;

public class DomainException extends NoStacktraceException {

    public DomainException(final String message) {
        super(message);
    }

}
