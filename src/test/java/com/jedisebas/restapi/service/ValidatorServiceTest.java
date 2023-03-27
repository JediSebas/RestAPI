package com.jedisebas.restapi.service;

import org.junit.jupiter.api.Test;

import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.PersonalDetailsDto;

import static org.junit.Assert.assertThrows;

class ValidatorServiceTest {

    @Test
    void givenPersonalDetailsDto_whenValidate() {
        ValidatorService validator = new ValidatorService();

        PersonalDetailsDto validDto = TestDataProvider.createValidPersonalDetailsDto();
        PersonalDetailsDto tooLongFieldDto;
        PersonalDetailsDto notValidEmailDto;
        PersonalDetailsDto nullFieldsDto = TestDataProvider.createNullFieldsPersonalDetailsDto();
        PersonalDetailsDto emptyFieldsDto = TestDataProvider.createEmptyFieldsPersonalDetailsDto();
        PersonalDetailsDto oneSpaceFieldsDto = TestDataProvider.createOneSpaceFieldsPersonalDetailsDto();
        PersonalDetailsDto nullAddressFieldsDto = TestDataProvider.createNullAddressFieldsPersonalDetailsDto();
        PersonalDetailsDto nullDto = null;

        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(nullFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(emptyFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(oneSpaceFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(nullAddressFieldsDto));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePersonalDetailsDtoFields(nullDto));
    }

}