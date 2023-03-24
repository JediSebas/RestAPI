package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor
public class ValidatorService {

    public void validatePersonalDetailsDtoFields(final PersonalDetailsDto personalDto) {
        checkIfNullAndEmpty(personalDto.getFirstName(), personalDto.getLastName(), personalDto.getEmail());

        if (personalDto.getFirstName().length() > 50 || personalDto.getLastName().length() > 50 || personalDto.getEmail().length() > 50) {
            throw new IllegalArgumentException();
        }

        final Pattern emailPattern = Pattern.compile("^\\S+@\\S+\\.\\S+$");

        if (!emailPattern.matcher(personalDto.getEmail()).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateEventDtoFields(final EventDto eventDto) {
        checkIfNullAndEmpty(eventDto.getDate(), eventDto.getTitle(), eventDto.getDescription());
    }

    private void checkIfNullAndEmpty(String... strings) {
        for (final String string : strings) {
            if (string == null || string.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
