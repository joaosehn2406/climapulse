package com.climapulse.jceco.shared.exception;

public class InvalidCoordinateException extends ClimapulseException {

    public InvalidCoordinateException(double latitude, double longitude) {
      super("Invalid coordinate: latitude = %s, longitude = %s".formatted(latitude, longitude));
    }
}
