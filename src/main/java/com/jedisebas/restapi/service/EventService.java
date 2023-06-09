package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedEntityResponse;
import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.entity.Event;
import com.jedisebas.restapi.mapper.EventMapper;
import com.jedisebas.restapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;
    private final ValidatorService validator;

    public CreatedEntityResponse createEvent(final EventDto eventDto) {
        try {
            validator.validateEventDtoFields(eventDto);
            Event event = mapper.dtoToEntity(eventDto);
            Event savedEvent = repository.save(event);

            return mapper.entityToResponse(savedEvent);
        } catch (final IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong request data provided");
        }
    }

    public List<EventDto> fetchAllEvents() {
        List<EventDto> toReturn = new ArrayList<>();
        repository.findAll().forEach(event -> toReturn.add(mapper.entityToDto(event)));

        return toReturn;
    }

    public EventDto fetchEvent(final int id) {
        final Event event = repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mapper.entityToDto(event);
    }
}
