--liquibase formatted sql

--changeset JediSebas:3
--comment: Create address table
CREATE TABLE IF NOT EXISTS address(
id INT PRIMARY KEY AUTO_INCREMENT,
street VARCHAR(85),
house_number VARCHAR(20),
city VARCHAR(85)
);

--changeset JediSebas:4
--comment: Migrate data
--INSERT INTO address (house_number, city, street)
--VALUES (
--(SELECT SUBSTRING(address FROM 1 FOR POSITION(' ' IN address) - 1) FROM personal_details),
--(SELECT SUBSTRING(
--        address,
--        POSITION(' ' IN address) + 1,
--        POSITION(' ' IN address, POSITION(' ' IN address) + 1) - POSITION(' ' IN address) - 1
--        )  FROM personal_details),
--(SELECT SUBSTRING(
--        address,
--        POSITION(' ' IN address, POSITION(' ' IN address) + 1) - POSITION(' ' IN address) - 1,
--        LENGTH(address)
--        ) FROM personal_details)
--);
INSERT INTO address (city)
SELECT address FROM personal_details;

--changeset JediSebas:5
--comment: Delete address column
ALTER TABLE personal_details
DROP COLUMN address;

--changeset JediSebas:6
--comment: Added address_id column
ALTER TABLE personal_details
ADD address_id INT;

--changeset JediSebas:7
--comment: Added address_id as fk
ALTER TABLE personal_details
ADD FOREIGN KEY (address_id)
REFERENCES address (id);

--changeset JediSebas:8
--comment: Insert address_id
INSERT INTO personal_details (address_id)
SELECT id FROM address;