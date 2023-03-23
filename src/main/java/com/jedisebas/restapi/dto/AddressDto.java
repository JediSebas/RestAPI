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
public class AddressDto {

    private String street;

    @JsonProperty(DataTransferConstants.HOUSE_NUMBER)
    private String houseNumber;

    private String city;
}
