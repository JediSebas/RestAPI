package com.jedisebas.restapi.controller;

import com.jedisebas.restapi.dto.CreatedEventResponse;
import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/events",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedEventResponse createEvent(@RequestBody EventDto eventDto) {
        return service.createEvent(eventDto);
    }

    @GetMapping
    public List<EventDto> getAll() {
        return service.fetchAllEvents();
    }

    @GetMapping("/{id}")
    public EventDto getById(@PathVariable final int id) {
        return service.fetchEvent(id);
    }
}
