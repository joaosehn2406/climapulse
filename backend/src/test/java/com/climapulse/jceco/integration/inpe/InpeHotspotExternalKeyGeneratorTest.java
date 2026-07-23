package com.climapulse.jceco.integration.inpe;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class InpeHotspotExternalKeyGeneratorTest {

    private final InpeHotspotExternalKeyGenerator generator =
            new InpeHotspotExternalKeyGenerator();

    @Test
    void shouldGenerateSameKeyForTheSameHotspot() {
        var hotspot = new InpeHotspot(
                -11.828400,
                -44.757900,
                "GOES-19",
                Instant.parse("2026-07-19T16:20:00Z")
        );

        var firstKey = generator.generate(hotspot);
        var secondKey = generator.generate(hotspot);

        assertThat(firstKey)
                .isEqualTo(secondKey)
                .isEqualTo("f5923cc9b278b690e3acce180504f82d6c78797f7bad6ff681ade2f8ca5f51f5");
    }

    @Test
    void shouldGenerateDifferentKeyWhenHotspotChanges() {
        var observedAt = Instant.parse("2026-07-19T16:20:00Z");
        var firstHotspot = new InpeHotspot(
                -11.828400,
                -44.757900,
                "GOES-19",
                observedAt
        );
        var secondHotspot = new InpeHotspot(
                -11.828400,
                -44.757800,
                "GOES-19",
                observedAt
        );

        assertThat(generator.generate(firstHotspot))
                .isNotEqualTo(generator.generate(secondHotspot));
    }
}
