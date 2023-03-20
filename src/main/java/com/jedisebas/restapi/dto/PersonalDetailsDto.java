package com.jedisebas.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jedisebas.restapi.Constants;
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

    @JsonProperty(Constants.FIRST_NAME)
    private String firstName;

    @JsonProperty(Constants.LAST_NAME)
    private String lastName;
    private String address;
    private String email;
}