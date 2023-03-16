package com.jedisebas.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetailsDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String email;

    public PersonalDetailsDto anonymize() {
        lastName = String.valueOf(lastName.charAt(0));
        return this;
    }
}
