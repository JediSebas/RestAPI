package com.jedisebas.restapi.service;

import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepository repository;

    public List<PersonalDetails> fetchAllPersonalDetails() {
        return repository.findAll();
    }

    public void savePersonalDetails(PersonalDetails personalDetails) {
        repository.save(personalDetails);
    }

    public void saveAllPersonalDetails(List<PersonalDetails> personalDetailsList) {
        repository.saveAll(personalDetailsList);
    }
}
