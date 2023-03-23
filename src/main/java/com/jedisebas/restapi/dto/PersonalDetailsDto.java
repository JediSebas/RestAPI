package com.jedisebas.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jedisebas.restapi.constants.DataTransferConstants;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetailsDto {

    @JsonProperty(DataTransferConstants.FIRST_NAME)
    private String firstName;

    @JsonProperty(DataTransferConstants.LAST_NAME)
    private String lastName;
    private String email;
    private AddressDto address;
}