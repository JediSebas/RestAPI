package com.jedisebas.restapi.constants;

import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataProvider {

    public static PersonalDetails createProperlyPersonalDetails() {
        return PersonalDetails.builder()
                .firstName("Szymon")
                .lastName("Marciniak")
                .address("Kalisz")
                .email("szymonmarciniak@gmail.com")
                .build();
    }

    public static PersonalDetails createProperlyPersonalDetailsWithId() {
        return PersonalDetails.builder()
                .id(1)
                .firstName("Szymon")
                .lastName("Marciniak")
                .address("Kalisz")
                .email("szymonmarciniak@gmail.com")
                .build();
    }

    public static PersonalDetailsDto createProperlyPersonalDetailsDto() {
        return PersonalDetailsDto.builder()
                .firstName("Szymon")
                .lastName("Marciniak")
                .address("Kalisz")
                .email("szymonmarciniak@gmail.com")
                .build();
    }
}
