package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;

@ExtendWith(MockitoExtension.class)
class PersonalDetailsMapperTest {

    @Mock
    private AddressMapper addressMapper;

    @InjectMocks
    private PersonalDetailsMapper mapper;

    @Before
    void setUp() {
        reset(addressMapper);
    }

    @Test
    void givenDto_whenMapping_thenReturnEntity() {
        PersonalDetailsDto dto = TestDataProvider.createValidPersonalDetailsDto();

        PersonalDetails entity = mapper.dtoToEntity(dto);

        assertEquals(dto.getFirstName(), entity.getFirstName());
        assertEquals(dto.getLastName(), entity.getLastName());
        assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    void givenEntity_whenMapping_thenReturnDto() {
        PersonalDetails entity = TestDataProvider.createValidPersonalDetails();

        PersonalDetailsDto dto = mapper.entityToDto(entity);

        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getEmail(), dto.getEmail());
    }

    @Test
    void givenEntity_whenAnonymizedMapping_thenReturnDto() {
        PersonalDetails entity = TestDataProvider.createValidPersonalDetails();

        PersonalDetailsDto dto = mapper.entityToDtoAnonymized(entity);

        assertEquals("Szymon", dto.getFirstName());
        assertEquals("M********", dto.getLastName());
        assertEquals("s***k@g***l.com", dto.getEmail());
    }

    @Test
    void givenEntity_whenMapping_thenReturnResponse() {
        PersonalDetails entity = TestDataProvider.createValidPersonalDetailsWithId();

        CreatedPersonResponse response = mapper.entityToResponse(entity);

        assertEquals(entity.getId(), response.getId());
    }
}