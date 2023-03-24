package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.dto.CreatedEventResponse;
import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public Event dtoToEntity(EventDto eventDto) {
        return Event.builder()
                .title(eventDto.getTitle())
                .date(eventDto.getDate())
                .description(eventDto.getDescription())
                .build();
    }

    public EventDto entityToDto(Event event) {
        return EventDto.builder()
                .title(event.getTitle())
                .date(event.getDate())
                .description(event.getDescription())
                .build();
    }

    public CreatedEventResponse entityToResponse(Event savedEvent) {
        return new CreatedEventResponse(savedEvent.getId());
    }
}
