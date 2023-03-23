package com.jedisebas.restapi.constants;

import com.jedisebas.restapi.dto.AddressDto;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.Address;
import com.jedisebas.restapi.entity.PersonalDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataProvider {

    private static final String VALID_FIRST_NAME = "Szymon";
    private static final String VALID_LAST_NAME = "Marciniak";
    private static final String VALID_EMAIL = "szymonmarciniak@gmail.com";

    private static final String VALID_CITY = "Kalisz";
    private static final String VALID_STREET = "ostrowska";
    private static final String VALID_HOUSE_NUMBER = "22";

    public static PersonalDetails createValidPersonalDetails() {
        return PersonalDetails.builder()
                .firstName(VALID_FIRST_NAME)
                .lastName(VALID_LAST_NAME)
                .email(VALID_EMAIL)
                .address(createValidAddress())
                .build();
    }

    public static PersonalDetails createValidPersonalDetailsWithId() {
        return PersonalDetails.builder()
                .id(1)
                .firstName(VALID_FIRST_NAME)
                .lastName(VALID_LAST_NAME)
                .email(VALID_EMAIL)
                .address(createValidAddress())
                .build();
    }

    public static PersonalDetailsDto createValidPersonalDetailsDto() {
        return PersonalDetailsDto.builder()
                .firstName(VALID_FIRST_NAME)
                .lastName(VALID_LAST_NAME)
                .email(VALID_EMAIL)
                .address(createValidAddressDto())
                .build();
    }

    public static Address createValidAddress() {
        return Address.builder()
                .city(VALID_CITY)
                .houseNumber(VALID_HOUSE_NUMBER)
                .street(VALID_STREET)
                .build();
    }

    public static AddressDto createValidAddressDto() {
        return AddressDto.builder()
                .city(VALID_CITY)
                .houseNumber(VALID_HOUSE_NUMBER)
                .street(VALID_STREET)
                .build();
    }
}
