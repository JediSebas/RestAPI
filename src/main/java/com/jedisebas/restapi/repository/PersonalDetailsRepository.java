package com.jedisebas.restapi.repository;

import com.jedisebas.restapi.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {
}
