package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PersonalDetailsController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private PersonalDetailsService service;

    @PostMapping("/persons")
    public CreatedPersonResponse create(@RequestBody final PersonalDetailsDto personalDTO) {
        return service.createPersonalDetails(personalDTO);
    }
}