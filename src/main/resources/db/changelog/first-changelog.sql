--liquibase formatted sql

--changeset JediSebas:2
--comment: Creating table personal_details
CREATE TABLE IF NOT EXISTS personal_details(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
address VARCHAR(100),
email VARCHAR(50)
);

