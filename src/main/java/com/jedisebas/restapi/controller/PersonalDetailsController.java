package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService service;
}
