package com.jedisebas.restapi.service;

import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.CreatedEntityResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonalDetailsServiceTest {

    private static final int ID = 1;

    @Mock
    private PersonalDetailsMapper mapper;

    @Mock
    private PersonalDetailsRepository repository;

    @Mock
    private ValidatorService validator;

    @InjectMocks
    private PersonalDetailsService service;

    @BeforeEach
    public void setUp() {
        reset(mapper, repository);
    }

    @Test
    void createPersonalDetailsSuccessful() {
        PersonalDetailsDto requestBody = TestDataProvider.createValidPersonalDetailsDto();
        PersonalDetails expectedEntityToSave = new PersonalDetails();
        PersonalDetails savedEntity = new PersonalDetails();
        CreatedEntityResponse response = new CreatedEntityResponse(ID);

        when(mapper.dtoToEntity(requestBody)).thenReturn(expectedEntityToSave);
        when(repository.save(expectedEntityToSave)).thenReturn(savedEntity);
        when(mapper.entityToResponse(savedEntity)).thenReturn(response);

        CreatedEntityResponse actualResponse =  service.createPersonalDetails(requestBody);

        assertEquals(actualResponse, response);
        verify(mapper, never()).entityToResponse(expectedEntityToSave);
        verify(mapper, times(1)).entityToResponse(savedEntity);
    }

    @Test
    void fetchPersonalDetailsByIdThrowsNotFoundException() {
        when(repository.findById(ID)).thenThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, () -> service.fetchPersonalDetails(ID));
    }

    @Test
    void fetchAllPersonalDetailsEmpty() {
        when(repository.findAll()).thenReturn(List.of());
        assertEquals(List.of(), service.fetchAllPersonalDetails());
    }
}