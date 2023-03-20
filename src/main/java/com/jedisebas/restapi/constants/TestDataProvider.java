package com.jedisebas.restapi.constants;

import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataProvider {

    private static final String PROPERLY_FIRST_NAME = "Szymon";
    private static final String PROPERLY_LAST_NAME = "Marciniak";
    private static final String PROPERLY_ADDRESS = "Kalisz";
    private static final String PROPERLY_EMAIL = "szymonmarciniak@gmail.com";

    public static PersonalDetails createProperlyPersonalDetails() {
        return PersonalDetails.builder()
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .address(PROPERLY_ADDRESS)
                .email(PROPERLY_EMAIL)
                .build();
    }

    public static PersonalDetails createProperlyPersonalDetailsWithId() {
        return PersonalDetails.builder()
                .id(1)
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .address(PROPERLY_ADDRESS)
                .email(PROPERLY_EMAIL)
                .build();
    }

    public static PersonalDetailsDto createProperlyPersonalDetailsDto() {
        return PersonalDetailsDto.builder()
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .address(PROPERLY_ADDRESS)
                .email(PROPERLY_EMAIL)
                .build();
    }
}
