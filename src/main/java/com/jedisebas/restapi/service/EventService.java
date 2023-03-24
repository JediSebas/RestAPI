package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedEventResponse;
import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.entity.Event;
import com.jedisebas.restapi.mapper.EventMapper;
import com.jedisebas.restapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;

    public CreatedEventResponse createEvent(final EventDto eventDto) {
        ValidatorService validator = new ValidatorService();
        validator.validateEventDtoFields(eventDto);

        Event event = mapper.dtoToEntity(eventDto);
        Event savedEvent = repository.save(event);

        return mapper.entityToResponse(savedEvent);
    }

}
