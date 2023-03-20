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

    public PersonalDetailsDto anonymize() {

        lastName = anonymizeLastName(lastName);
        email = anonymizeEmail(email);

        return this;
    }

    private String anonymizeLastName(final String lastName) {
        return lastName.charAt(0) + "*".repeat(lastName.length() - 1);
    }

    private String anonymizeEmail(final String email) {
        final StringBuilder emailBuilder = new StringBuilder();
        emailBuilder.append(email.charAt(0));
        emailBuilder.append("*".repeat(3));

        int i = 4;
        while (email.charAt(i + 1) != '@') {
            i++;
        }

        for (int j = 0; j < 3; j++) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        emailBuilder.append("*".repeat(3));

        while (email.charAt(i + 1) != '.') {
            i++;
        }

        for (int j = 0; j < 2; j++) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        while (i < email.length()) {
            emailBuilder.append(email.charAt(i));
            i++;
        }

        return emailBuilder.toString();
    }
}