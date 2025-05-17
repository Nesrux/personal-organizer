package com.nesrux.organizer.utils;

import com.nesrux.organizer.domain.exceptions.DomainException;

public final class StringUtils {

    private StringUtils() {
    }

    public static String validate(final String text, final String field) {
        if (text == null) {
            throw new DomainException(field + " not be null");
        }

        String valor = text.trim();

        if (valor.isEmpty()) {
            throw new DomainException(field + " not be empty.");
        }

        if (valor.length() < 4) {
            throw new DomainException(field + " must have at least 4 characters.");
        }

        if (valor.length() > 255) {
            throw new DomainException(field + " must have a maximum of 255 characters.");
        }

        return text;
    }
}
