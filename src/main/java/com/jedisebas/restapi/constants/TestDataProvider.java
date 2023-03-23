package com.jedisebas.restapi.constants;

import com.jedisebas.restapi.dto.AddressDto;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.Address;
import com.jedisebas.restapi.entity.PersonalDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataProvider {

    private static final String PROPERLY_FIRST_NAME = "Szymon";
    private static final String PROPERLY_LAST_NAME = "Marciniak";
    private static final String PROPERLY_EMAIL = "szymonmarciniak@gmail.com";

    private static final String PROPERLY_CITY = "Kalisz";
    private static final String PROPERLY_STREET = "ostrowska";
    private static final String PROPERLY_HOUSE_NUMBER = "22";

    public static PersonalDetails createProperlyPersonalDetails() {
        return PersonalDetails.builder()
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .email(PROPERLY_EMAIL)
                .address(createProperlyAddress())
                .build();
    }

    public static PersonalDetails createProperlyPersonalDetailsWithId() {
        return PersonalDetails.builder()
                .id(1)
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .email(PROPERLY_EMAIL)
                .address(createProperlyAddress())
                .build();
    }

    public static PersonalDetailsDto createProperlyPersonalDetailsDto() {
        return PersonalDetailsDto.builder()
                .firstName(PROPERLY_FIRST_NAME)
                .lastName(PROPERLY_LAST_NAME)
                .email(PROPERLY_EMAIL)
                .address(createProperlyAddressDto())
                .build();
    }

    public static Address createProperlyAddress() {
        return Address.builder()
                .city(PROPERLY_CITY)
                .houseNumber(PROPERLY_HOUSE_NUMBER)
                .street(PROPERLY_STREET)
                .build();
    }

    public static AddressDto createProperlyAddressDto() {
        return AddressDto.builder()
                .city(PROPERLY_CITY)
                .houseNumber(PROPERLY_HOUSE_NUMBER)
                .street(PROPERLY_STREET)
                .build();
    }
}
