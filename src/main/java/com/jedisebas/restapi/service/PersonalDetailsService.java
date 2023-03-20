package com.jedisebas.restapi.service;

import com.jedisebas.restapi.dto.CreatedPersonResponse;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.entity.PersonalDetails;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalDetailsService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final PersonalDetailsRepository repository;
    private final PersonalDetailsMapper mapper;

    public CreatedPersonResponse createPersonalDetails(final PersonalDetailsDto personalDto) {

        // validation
        PersonalDetails personalDetails = mapper.dtoToEntity(personalDto);
        PersonalDetails savedEntity = repository.save(personalDetails);

        // move to mapper to keep nice and tidy interface
        return new CreatedPersonResponse(savedEntity.getId());
    }
}
