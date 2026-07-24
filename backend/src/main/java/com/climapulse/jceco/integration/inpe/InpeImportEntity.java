package com.climapulse.jceco.integration.inpe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "inpe_file", schema = "climapulse")
class InpeImportEntity {

    @Id
    @Column(length = 80)
    private String filename;

    @Column(name = "imported_at", nullable = false)
    private Instant importedAt;

    InpeImportEntity(String filename, Instant importedAt) {
        this.filename = filename;
        this.importedAt = importedAt;
    }
}