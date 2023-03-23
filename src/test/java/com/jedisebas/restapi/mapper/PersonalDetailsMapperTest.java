package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonalDetailsMapperTest {

    @Test
    void givenDto_whenMapping_thenReturnEntity() {
        PersonalDetailsMapper mapper = new PersonalDetailsMapper();

        PersonalDetailsDto dto = TestDataProvider.createProperlyPersonalDetailsDto();

        PersonalDetails entity = mapper.dtoToEntity(dto);

        assertEquals(dto.getFirstName(), entity.getFirstName());
        assertEquals(dto.getLastName(), entity.getLastName());
        assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    void givenEntity_whenMapping_thenReturnDto() {
        PersonalDetailsMapper mapper = new PersonalDetailsMapper();

        PersonalDetails entity = TestDataProvider.createProperlyPersonalDetails();

        PersonalDetailsDto dto = mapper.entityToDto(entity);

        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getEmail(), dto.getEmail());
    }

    @Test
    void givenEntity_whenAnonymizedMapping_thenReturnDto() {
        PersonalDetailsMapper mapper = new PersonalDetailsMapper();

        PersonalDetails entity = TestDataProvider.createProperlyPersonalDetails();

        PersonalDetailsDto dto = mapper.entityToDtoAnonymized(entity);

        assertEquals("Szymon", dto.getFirstName());
        assertEquals("M********", dto.getLastName());
        assertEquals("s***k@g***l.com", dto.getEmail());
    }

    @Test
    void givenEntity_whenMapping_thenReturnResponse() {
        PersonalDetailsMapper mapper = new PersonalDetailsMapper();

        PersonalDetails entity = TestDataProvider.createProperlyPersonalDetailsWithId();

        CreatedPersonResponse response = mapper.entityToResponse(entity);

        assertEquals(entity.getId(), response.getId());
    }
}