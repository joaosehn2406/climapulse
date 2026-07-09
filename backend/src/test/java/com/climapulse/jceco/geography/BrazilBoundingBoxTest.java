package com.climapulse.jceco.geography;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BrazilBoundingBoxTest {

    private final BrazilBoundingBox brazilBoundingBox = new BrazilBoundingBox();

    @Test
    void shouldReturnTrueWhenCoordinatesAreInsideBrazilBoundingBox() {
        boolean result = brazilBoundingBox.isInsideBrazilBoundingBox(-26.9189, -49.0661);

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenCoordinatesAreOutsideBrazilBoundingBox() {
        boolean result = brazilBoundingBox.isInsideBrazilBoundingBox(40.4168, -3.7038);

        assertThat(result).isFalse();
    }

    @Test
    void shouldIncludeCoordinatesOnBoundingBoxLimits() {
        assertThat(brazilBoundingBox.isInsideBrazilBoundingBox(-34, -74)).isTrue();
        assertThat(brazilBoundingBox.isInsideBrazilBoundingBox(6, -34)).isTrue();
    }
}