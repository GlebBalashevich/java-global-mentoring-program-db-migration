revoke usage on schema public from public;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS companies
(
    id               UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    website          VARCHAR(50)  NOT NULL,
    email            TEXT         NOT NULL,
    address          TEXT
);

CREATE TABLE IF NOT EXISTS candidates
(
    id               UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    given_name       VARCHAR(50) NOT NULL,
    family_name      VARCHAR(50) NOT NULL,
    specialty        VARCHAR(20) NOT NULL,
    company_id       UUID        NOT NULL,
    email            TEXT        NOT NULL UNIQUE,
    birth_date       DATE        NOT NULL,
    hire_date        DATE        NOT NULL,
    salary           NUMERIC     NOT NULL,
    title            TEXT        NOT NULL,
    is_deleted       BOOLEAN     NOT NULL,
    create_date      TIMESTAMP   NOT NULL,
    last_update_date TIMESTAMP   NOT NULL,
    CONSTRAINT fk_company FOREIGN KEY(company_id) REFERENCES companies(id)
);
