package com.jedisebas.restapi;

import com.jedisebas.restapi.constants.JsonRequestProvider;
import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonalDetailsMapper mapper;

	@Autowired
	private PersonalDetailsRepository repository;

	@Autowired
	private PersonalDetailsService service;

	@Test
	void personalDetailsCreate() throws Exception {
		final PersonalDetailsDto personalDetailsDto = TestDataProvider.createValidPersonalDetailsDto();

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/persons")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonRequestProvider.EVENT_PERSONAL_DETAILS)
		);

		final PersonalDetailsDto testIfWorks = service.fetchPersonalDetails(1);

		assertEquals(personalDetailsDto.getEmail(), testIfWorks.getEmail());
	}
}
