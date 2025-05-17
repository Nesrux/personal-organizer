package com.nesrux.organizer.utils;

import com.nesrux.organizer.domain.exceptions.DomainException;

public final class StringUtils {

    private StringUtils() {
    }

    public static void validar(final String text) {
        if (text == null) {
            throw new DomainException(text + " not be null");
        }

        String valor = text.trim();

        if (valor.isEmpty()) {
            throw new DomainException(text + " not be empty.");
        }

        if (valor.length() < 4) {
            throw new DomainException(text + " must have at least 4 characters.");
        }

        if (valor.length() > 255) {
            throw new DomainException(text + " must have a maximum of 255 characters.");
        }
    }
}
