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

    public CreatedPersonResponse entityToResponse(PersonalDetails savedEntity) {
        return new CreatedPersonResponse(savedEntity.getId());
    }
}
