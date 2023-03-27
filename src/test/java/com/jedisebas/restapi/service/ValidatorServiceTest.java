package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.EventDto;
import org.junit.jupiter.api.Test;

import com.jedisebas.restapi.dto.PersonalDetailsDto;

import static com.jedisebas.restapi.constants.TestDataProvider.*;
import static org.junit.Assert.assertThrows;

class ValidatorServiceTest {

    @Test
    void givenPersonalDetailsDto_whenValidate_thenThrowsException() {
        ValidatorService validator = new ValidatorService();

        PersonalDetailsDto tooLongFieldsDto = createTooLongFieldsPersonalDetailsDto();
        PersonalDetailsDto invalidEmailDto = createInvalidEmailPersonalDetailsDto();
        PersonalDetailsDto nullFieldsDto = createNullFieldsPersonalDetailsDto();
        PersonalDetailsDto emptyFieldsDto = createEmptyFieldsPersonalDetailsDto();
        PersonalDetailsDto oneSpaceFieldsDto = createOneSpaceFieldsPersonalDetailsDto();
        PersonalDetailsDto nullAddressFieldsDto = createNullAddressFieldsPersonalDetailsDto();

        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(nullFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(emptyFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(oneSpaceFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(nullAddressFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(null));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(tooLongFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(invalidEmailDto));
    }

    @Test
    void givenEventDto_whenValidate_thenThrowsException() {
        ValidatorService validator = new ValidatorService();

        EventDto nullFieldsDto = createNullFieldsEventDto();
        EventDto emptyFieldsDto = createEmptyFieldsEventDto();
        EventDto oneSpaceFieldsDto = createOneSpaceFieldsEventDto();

        assertThrows(IllegalArgumentException.class, () -> validator.validateEventDtoFields(nullFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validateEventDtoFields(emptyFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validateEventDtoFields(oneSpaceFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validateEventDtoFields(null));
    }
}