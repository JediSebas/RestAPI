package com.jedisebas.restapi.service;

import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepository repository;

    public PersonalDetails createPersonalDetails(final PersonalDetails personalDetails) {
        return repository.save(personalDetails);
    }
}
