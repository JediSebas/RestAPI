--liquibase formatted sql

--changeset JediSebas:1
--comment: I'm not sure what I'm doing, creating table
CREATE TABLE personal_details(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
address VARCHAR(100),
email VARCHAR(50)
);


