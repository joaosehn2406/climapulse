package com.climapulse.jceco.geography;

public class BrazilBoundingBox {

    private static final double MIN_LATITUDE = -34;
    private static final double MAX_LATITUDE = 6;
    private static final double MIN_LONGITUDE = -74;
    private static final double MAX_LONGITUDE = -34;

    public boolean isInsideBrazilBoundingBox(double latitude, double longitude) {
        return latitude >= MIN_LATITUDE
                && latitude <= MAX_LATITUDE
                && longitude >= MIN_LONGITUDE
                && longitude <= MAX_LONGITUDE;
    }
}
