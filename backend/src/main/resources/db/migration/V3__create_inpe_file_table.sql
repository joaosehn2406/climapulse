CREATE TABLE inpe_file (
    filename VARCHAR(80) PRIMARY KEY,
    imported_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);