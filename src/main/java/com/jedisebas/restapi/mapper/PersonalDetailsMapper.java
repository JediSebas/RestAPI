package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.service.AnonymizeService;
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
                .lastName(AnonymizeService.anonymizeLastName(personalDetails.getLastName()))
                .email(AnonymizeService.anonymizeEmail(personalDetails.getEmail()))
                .address(personalDetails.getAddress())
                .build();
    }

    public CreatedPersonResponse entityToResponse(PersonalDetails savedEntity) {
        return new CreatedPersonResponse(savedEntity.getId());
    }
}
