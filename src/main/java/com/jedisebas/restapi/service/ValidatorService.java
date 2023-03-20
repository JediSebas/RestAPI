package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.PersonalDetailsDto;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor
public class ValidatorService {

    public void validatePersonalDetailsDtoFields(final PersonalDetailsDto personalDto) {
        if (personalDto.getFirstName() == null || personalDto.getLastName() == null ||
                personalDto.getAddress() == null || personalDto.getEmail() == null) {
            throw new IllegalArgumentException();
        }

        if (personalDto.getFirstName().isEmpty() || personalDto.getLastName().isEmpty() ||
                personalDto.getAddress().isEmpty() || personalDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (personalDto.getFirstName().length() > 50 || personalDto.getLastName().length() > 50 ||
                personalDto.getEmail().length() > 50) {
            throw new IllegalArgumentException();
        }

        final Pattern emailPattern = Pattern.compile("^\\S+@\\S+\\.\\S+$");

        if (!emailPattern.matcher(personalDto.getEmail()).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
