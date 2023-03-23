package com.jedisebas.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	void personalDetailsCreate() throws Exception {
		PersonalDetailsDto personalDetailsDto = TestDataProvider.createValidPersonalDetailsDto();
		String ownJson = """
				{
				    "first_name": "Szymon",
				    "last_name": "Marciniak",
				    "email": "szymonmarciniak@gmail.com",
				    "address": {
				        "city": "Gdansk",
				        "street": "Jana z Kolna",
				        "house_number": "11" 
				    }
				}
				""";

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/persons")
				.contentType(MediaType.APPLICATION_JSON)
				.content(ownJson)
		);

		PersonalDetailsDto testIfWorks = service.fetchPersonalDetails(1);

		assertEquals(personalDetailsDto.getEmail(), testIfWorks.getEmail());
	}
}
