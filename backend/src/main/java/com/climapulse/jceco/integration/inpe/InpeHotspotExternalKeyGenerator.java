package com.climapulse.jceco.integration.inpe;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Locale;

@Component
public class InpeHotspotExternalKeyGenerator {

    public String generate(InpeHotspot hotspot) {
        var content = String.format(
                Locale.ROOT,
                "%s|%s|%.5f|%.5f",
                hotspot.satellite(),
                hotspot.observedAt(),
                hotspot.latitude(),
                hotspot.longitude()
        );

        try {
            var digest = MessageDigest.getInstance("SHA-256");
            var hash = digest.digest(content.getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("SHA-256 algorithm is unavailable", exception);
        }
    }
}
