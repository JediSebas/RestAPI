package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.EventDto;
import org.junit.jupiter.api.Test;

import com.jedisebas.restapi.dto.PersonalDetailsDto;

import static com.jedisebas.restapi.constants.TestDataProvider.*;
import static org.junit.Assert.assertThrows;

class ValidatorServiceTest {

    private final ValidatorService validator = new ValidatorService();

    @Test
    void givenPersonalDetailsDto_whenValidate_thenThrowsException() {
        assertThrowsIllegalArgumentException(createNullFieldsPersonalDetailsDto());
        assertThrowsIllegalArgumentException(createTooLongFieldsPersonalDetailsDto());
        assertThrowsIllegalArgumentException(createInvalidEmailPersonalDetailsDto());
        assertThrowsIllegalArgumentException(createEmptyFieldsPersonalDetailsDto());
        assertThrowsIllegalArgumentException(createOneSpaceFieldsPersonalDetailsDto());
        assertThrowsIllegalArgumentException(createNullAddressFieldsPersonalDetailsDto());
        assertThrowsIllegalArgumentException((PersonalDetailsDto) null);
    }

    @Test
    void givenEventDto_whenValidate_thenThrowsException() {
        assertThrowsIllegalArgumentException(createNullFieldsEventDto());
        assertThrowsIllegalArgumentException(createEmptyFieldsEventDto());
        assertThrowsIllegalArgumentException(createOneSpaceFieldsEventDto());
        assertThrowsIllegalArgumentException((EventDto) null);
    }

    private void assertThrowsIllegalArgumentException(final PersonalDetailsDto dto) {
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(dto));
    }

    private void assertThrowsIllegalArgumentException(final EventDto dto) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateEventDtoFields(dto));
    }
}