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

        emailBuilder.append(email.charAt(i));
        i++;
        emailBuilder.append(email.charAt(i));
        i++;
        emailBuilder.append(email.charAt(i));
        i++;

        emailBuilder.append("*".repeat(3));

        while (email.charAt(i + 1) != '.') {
            i++;
        }

        emailBuilder.append(email.charAt(i));
        i++;
        emailBuilder.append(email.charAt(i));
        i++;

        for (; i < email.length(); i++) {
            emailBuilder.append(email.charAt(i));
        }

        return emailBuilder.toString();
    }
}