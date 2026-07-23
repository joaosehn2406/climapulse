CREATE TABLE climapulse.hotspot (
    id UUID PRIMARY KEY,
    source_filename VARCHAR(80) NOT NULL,

    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    satellite VARCHAR(60) NOT NULL,
    observed_at TIMESTAMPTZ NOT NULL,

    CONSTRAINT fk_hotspot_inpe_file
        FOREIGN KEY (source_filename)
        REFERENCES climapulse.inpe_file(filename),

    CONSTRAINT ck_hotspot_latitude
        CHECK (latitude BETWEEN -90 AND 90),

    CONSTRAINT ck_hotspot_longitude
        CHECK (longitude BETWEEN -180 AND 180)
);
