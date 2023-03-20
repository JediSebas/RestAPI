package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/persons",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPersonResponse addPersonDetails(@RequestBody final PersonalDetailsDto personalDto) {
        return service.createPersonalDetails(personalDto);
    }

    @GetMapping
    public List<PersonalDetailsDto> getAll() {
        return service.fetchAllPersonalDetails();
    }

    @GetMapping("/{id}")
    public PersonalDetailsDto getById(@PathVariable int id) {
        return service.fetchPersonalDetails(id);
    }
}
