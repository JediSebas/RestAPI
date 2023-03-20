package com.jedisebas.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	void personalDetailsCreate() throws Exception {
		PersonalDetailsDto personalDetailsDto = PersonalDetailsDto.builder()
				.firstName("Szymon")
				.lastName("Marciniak")
				.address("Kalisz")
				.email("szymonmarciniak@gmail.com")
				.build();

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		mockMvc.perform(MockMvcRequestBuilders.post("/persons")
				.contentType(MediaType.APPLICATION_JSON)
				.param("personalDto", gson.toJson(personalDetailsDto))
				.content(gson.toJson(personalDetailsDto))
		);

		PersonalDetailsDto testIfWorks = service.fetchPersonalDetails(1);

		assertEquals(personalDetailsDto.getAddress(), testIfWorks.getAddress());
	}
}
