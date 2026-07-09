package com.climapulse.jceco.shared.exception;

public abstract class ClimapulseException extends RuntimeException {

    protected ClimapulseException(String message) {
        super(message);
    }

    protected ClimapulseException(String message, Throwable cause) {
        super(message, cause);
    }
}
