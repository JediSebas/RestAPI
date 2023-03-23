package com.jedisebas.restapi.mapper;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.service.AnonymizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsMapper {

    @Autowired
    private AddressMapper mapper;

    public PersonalDetails dtoToEntity(PersonalDetailsDto personalDto) {
        return PersonalDetails.builder()
                .firstName(personalDto.getFirstName())
                .lastName(personalDto.getLastName())
                .email(personalDto.getEmail())
                .address(mapper.dtoToEntity(personalDto.getAddress()))
                .build();
    }

    public PersonalDetailsDto entityToDto(PersonalDetails personalDetails) {
        return PersonalDetailsDto.builder()
                .firstName(personalDetails.getFirstName())
                .lastName(personalDetails.getLastName())
                .email(personalDetails.getEmail())
                .address(mapper.entityToDto(personalDetails.getAddress()))
                .build();
    }

    public PersonalDetailsDto entityToDtoAnonymized(PersonalDetails personalDetails) {
        return PersonalDetailsDto.builder()
                .firstName(personalDetails.getFirstName())
                .lastName(AnonymizeService.anonymizeAllWithoutFirstLetter(personalDetails.getLastName()))
                .email(AnonymizeService.anonymizeMiddleOfString(personalDetails.getEmail()))
                .address(mapper.entityToDtoAnonymized(personalDetails.getAddress()))
                .build();
    }

    public CreatedPersonResponse entityToResponse(PersonalDetails savedEntity) {
        return new CreatedPersonResponse(savedEntity.getId());
    }
}
