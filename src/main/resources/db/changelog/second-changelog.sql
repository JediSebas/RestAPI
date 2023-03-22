--liquibase formatted sql

--changeset JediSebas:3
--comment: Create address table
CREATE TABLE IF NOT EXIST address(
id INT PRIMARY KEY AUTO_INCREMENT,
street VARCHAR(85),
house_number VARCHAR(20),
city VARCHAR(85)
);

--changeset JediSebas:4
--comment: Migrate data
INSERT INTO address (house_number, city, street)
VALUES (
(SELECT split_part(address, ' ', 1) FROM personal_details),
(SELECT split_part(address, ' ', 2) FROM personal_details),
(SELECT split_part(address, ' ', 3) FROM personal_details)
);

--changeset JediSebas:5
--comment: Delete address column
ALTER TABLE personal_details
DROP COLUMN address;

--changeset JediSebas:6
--comment: Added address_id column
ALTER TABLE personal_details
ADD CONSTRAINT address_id
FOREIGN KEY (address_id) REFERENCES address(id);
