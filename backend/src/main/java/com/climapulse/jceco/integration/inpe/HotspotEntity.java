package com.climapulse.jceco.integration.inpe;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "hotspot", schema = "climapulse")
public class HotspotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "source_filename", nullable = false, length = 80)
    private String sourceFilename;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false, length = 60)
    private String satellite;

    @Column(name = "observed_at", nullable = false)
    private Instant observedAt;

    HotspotEntity(String sourceFilename, InpeHotspot hotspot) {
        this.sourceFilename = sourceFilename;
        this.latitude = hotspot.latitude();
        this.longitude = hotspot.longitude();
        this.satellite = hotspot.satellite();
        this.observedAt = hotspot.observedAt();
    }
}
