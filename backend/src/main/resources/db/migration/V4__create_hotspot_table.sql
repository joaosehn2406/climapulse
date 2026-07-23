CREATE TABLE hotspot (
    id UUID PRIMARY KEY,
    source_filename VARCHAR(100) NOT NULL
        REFERENCES inpe_import(filename),

    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    satellite VARCHAR(60) NOT NULL,
    observed_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_hotspot_source_filename
    ON hotspot(source_filename);