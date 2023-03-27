package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedEntityResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalDetailsService {

    private final PersonalDetailsRepository repository;
    private final PersonalDetailsMapper mapper;
    private final ValidatorService validator;

    public CreatedEntityResponse createPersonalDetails(final PersonalDetailsDto personalDto) {
        validator.validatePersonalDetailsDtoFields(personalDto);

        PersonalDetails personalDetails = mapper.dtoToEntity(personalDto);
        PersonalDetails savedEntity = repository.save(personalDetails);

        return mapper.entityToResponse(savedEntity);
    }

    public List<PersonalDetailsDto> fetchAllPersonalDetails() {
        List<PersonalDetailsDto> toReturn = new ArrayList<>();
        repository.findAll().forEach(personalDetails -> toReturn.add(mapper.entityToDtoAnonymized(personalDetails)));

        return toReturn;
    }

    public PersonalDetailsDto fetchPersonalDetails(final int id) {
        final PersonalDetails persons = repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found"));

        return mapper.entityToDto(persons);
    }
}
