CREATE TABLE IF NOT EXISTS specialties
(
    id               UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    create_date      TIMESTAMP NOT NULL,
    last_update_date TIMESTAMP NOT NULL
);

ALTER TABLE candidates
ADD COLUMN specialty_id UUID,
ADD CONSTRAINT fk_specialty FOREIGN KEY(specialty_id) REFERENCES specialties(id)
