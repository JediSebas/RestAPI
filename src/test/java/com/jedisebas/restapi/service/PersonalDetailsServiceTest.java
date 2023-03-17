package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PersonalDetailsServiceTest {

    @Test
    void test1() {
        PersonalDetailsMapper mapper = mock(PersonalDetailsMapper.class);
        PersonalDetailsRepository repository = mock(PersonalDetailsRepository.class);
        PersonalDetailsService service = mock(PersonalDetailsService.class);

        PersonalDetailsDto requestBody = new PersonalDetailsDto();
        PersonalDetails expectedEntityToSave = new PersonalDetails();
        PersonalDetails savedEntity = new PersonalDetails();
        CreatedPersonResponse response = new CreatedPersonResponse(1);

        when(mapper.dtoToEntity(requestBody)).thenReturn(expectedEntityToSave);
        when(repository.save(expectedEntityToSave)).thenReturn(savedEntity);
        when(mapper.entityToResponse(savedEntity)).thenReturn(response);

        CreatedPersonResponse actualResponse =  service.createPersonalDetails(requestBody);

        assertEquals(actualResponse, response);
    }
}