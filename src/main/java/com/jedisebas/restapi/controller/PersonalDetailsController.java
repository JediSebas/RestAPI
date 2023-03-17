package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService service;

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPersonResponse create(@RequestBody final PersonalDetailsDto personalDTO) {
        return service.createPersonalDetails(personalDTO);
    }

    @GetMapping("/persons")
    public List<PersonalDetailsDto> getAll() {
        return service.fetchAllPersonalDetails();
    }

    @GetMapping("/persons/{id}")
    public PersonalDetailsDto getById(@PathVariable int id) {
        return service.fetchPersonalDetails(id);
    }
}
