package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsMapper {

    public PersonalDetails dtoToEntity(PersonalDetailsDto personalDto) {
        return PersonalDetails.builder()
                .firstName(personalDto.getFirstName())
                .lastName(personalDto.getLastName())
                .email(personalDto.getEmail())
                .address(personalDto.getAddress())
                .build();
    }

    public PersonalDetailsDto entityToDto(PersonalDetails personalDetails) {
        return PersonalDetailsDto.builder()
                .firstName(personalDetails.getFirstName())
                .lastName(personalDetails.getLastName())
                .email(personalDetails.getEmail())
                .address(personalDetails.getAddress())
                .build();
    }

    public PersonalDetailsDto entityToDtoAnonymized(PersonalDetails personalDetails) {
        return PersonalDetailsDto.builder()
                .firstName(personalDetails.getFirstName())
                .lastName(anonymizeLastName(personalDetails.getLastName()))
                .email(anonymizeEmail(personalDetails.getEmail()))
                .address(personalDetails.getAddress())
                .build();
    }

    public CreatedPersonResponse entityToResponse(PersonalDetails savedEntity) {
        return new CreatedPersonResponse(savedEntity.getId());
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
