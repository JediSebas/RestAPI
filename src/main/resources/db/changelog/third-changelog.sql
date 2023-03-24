--liquibase formatted sql

--changeset JediSebas:9
--comment: Creating table event
CREATE TABLE IF NOT EXISTS event(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30),
date TIMESTAMP,
description VARCHAR(280)
);

--changeset JedSebas:10
--comment: Creating relation many-to-many
CREATE TABLE IF NOT EXISTS person_to_event(
id INT PRIMARY KEY AUTO_INCREMENT,
person_id INT,
event_id INT,
FOREIGN KEY (person_id) REFERENCES personal_details(id),
FOREIGN KEY (event_id) REFERENCES event(id)
);

