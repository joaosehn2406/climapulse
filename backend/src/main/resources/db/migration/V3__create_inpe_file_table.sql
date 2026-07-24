CREATE TABLE climapulse.inpe_file (
    filename VARCHAR(80) PRIMARY KEY NOT NULL,
    imported_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
