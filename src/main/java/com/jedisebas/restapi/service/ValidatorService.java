package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.AddressDto;
import com.jedisebas.restapi.dto.EventDto;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.AddressMapper;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class ValidatorService {

    public void validatePersonalDetailsDtoFields(final PersonalDetailsDto personalDto) {
        checkIfNull(personalDto);
        checkIfNull(personalDto.getAddress());
        checkIfNullOrEmpty(personalDto.getFirstName(), personalDto.getLastName(), personalDto.getEmail());
        AddressDto address = personalDto.getAddress();
        checkIfNullOrEmpty(address.getCity(), address.getHouseNumber(), address.getStreet());

        if (personalDto.getFirstName().length() > 50 || personalDto.getLastName().length() > 50 || personalDto.getEmail().length() > 50) {
            throw new IllegalArgumentException();
        }

        final Pattern emailPattern = Pattern.compile("^\\S+@\\S+\\.\\S+$");

        if (!emailPattern.matcher(personalDto.getEmail()).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateEventDtoFields(final EventDto eventDto) {
        checkIfNull(eventDto);
        checkIfNullOrEmpty(eventDto.getDate(), eventDto.getTitle(), eventDto.getDescription());
    }

    public void convertDtoToEntityWhenFieldsAreOk(final PersonalDetailsDto dto, final PersonalDetails personalDetails) {
        if (allowIfNotNullAndNotEmpty(dto.getFirstName())) {
            personalDetails.setFirstName(dto.getFirstName());
        }

        if (allowIfNotNullAndNotEmpty(dto.getLastName())) {
            personalDetails.setLastName(dto.getLastName());
        }

        if (allowIfNotNullAndNotEmpty(dto.getEmail())) {
            personalDetails.setEmail(dto.getEmail());
        }

        final AddressDto address = dto.getAddress();
        if (address != null) {
            if (allowIfNotNullAndNotEmpty(address.getCity())) {
                address.setCity(address.getCity());
            }

            if (allowIfNotNullAndNotEmpty(address.getCity())) {
                address.setStreet(address.getStreet());
            }

            if (allowIfNotNullAndNotEmpty(address.getHouseNumber())) {
                address.setHouseNumber(address.getHouseNumber());
            }

            final AddressMapper addressMapper = new AddressMapper();
            personalDetails.setAddress(addressMapper.dtoToEntity(dto.getAddress()));
        }
    }

    private boolean allowIfNotNullAndNotEmpty(String string) {
        if (string != null) {
            if (string.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PersonalDetailsService.WRONG_REQUEST_DATA_PROVIDED);
            }
            return true;
        }
        return false;
    }

    private void checkIfNullOrEmpty(String... strings) {
        for (final String string : strings) {
            if (string == null || string.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkIfNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
