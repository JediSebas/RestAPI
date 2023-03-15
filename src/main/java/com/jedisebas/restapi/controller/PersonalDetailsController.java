package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/persons")
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService service;

    @PostMapping()
    public String create(@RequestBody final PersonalDetails personalDetails) {
        return service.createPersonalDetails(personalDetails).getId().toString();
    }
}
