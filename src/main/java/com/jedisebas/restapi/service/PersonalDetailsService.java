package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedEntityResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.AddressMapper;
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
    private final AddressMapper addressMapper;
    private final ValidatorService validator;

    public CreatedEntityResponse createPersonalDetails(final PersonalDetailsDto personalDto) {
        try {
            validator.validatePersonalDetailsDtoFields(personalDto);
            PersonalDetails personalDetails = mapper.dtoToEntity(personalDto);
            PersonalDetails savedEntity = repository.save(personalDetails);

            return mapper.entityToResponse(savedEntity);
        } catch (final IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong request data provided");
        }
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

    public PersonalDetailsDto updatePersonalDetails(final int id, final PersonalDetailsDto personalDto) {
        try {
            validator.validatePersonalDetailsDtoFields(personalDto);

            final PersonalDetails foundedPerson = repository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found"));

            foundedPerson.setFirstName(personalDto.getFirstName());
            foundedPerson.setLastName(personalDto.getLastName());
            foundedPerson.setEmail(personalDto.getEmail());
            foundedPerson.setAddress(addressMapper.dtoToEntity(personalDto.getAddress()));

            update(foundedPerson);

            return mapper.entityToDto(foundedPerson);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong request data provided");
        }
    }

    private void update(final PersonalDetails personalDetails) {
        repository.updateById(personalDetails.getFirstName(), personalDetails.getLastName(), personalDetails.getAddress(),
                personalDetails.getEmail(), personalDetails.getId());
    }

    public List<PersonalDetailsDto> updateManyPersonalDetails(List<PersonalDetailsDto> personalDetailsDtoList) {
        personalDetailsDtoList.forEach(dto -> {
            final int id = dto.getId();

            if (id == 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong request data provided");
            }

            final PersonalDetails foundedPerson = repository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found"));

            if (dto.getFirstName() != null) {
                repository.updateFirstName(dto.getFirstName(), id);
            }

            if (dto.getLastName() != null) {
                repository.updateLastName(dto.getLastName(), id);
            }

            if (dto.getEmail() != null) {
                repository.updateEmail(dto.getEmail(), id);
            }

            if (dto.getAddress() != null) {
                repository.updateAddress(dto.getAddress(), id);
            }
        });

        return personalDetailsDtoList;
    }
}
