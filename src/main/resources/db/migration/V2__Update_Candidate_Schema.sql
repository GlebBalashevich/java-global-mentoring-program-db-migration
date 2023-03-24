ALTER TABLE candidates
ADD COLUMN phone_number VARCHAR(20) NOT NULL,
ALTER COLUMN specialty TYPE SMALLINT USING (specialty::smallint),
DROP COLUMN birth_date,
DROP COLUMN hire_date,
DROP COLUMN salary,
DROP COLUMN title,
DROP COLUMN is_deleted,
DROP COLUMN create_date,
DROP COLUMN last_update_date;

