package com.jedisebas.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jedisebas.restapi.constants.TestDataProvider;
import com.jedisebas.restapi.dto.PersonalDetailsDto;
import com.jedisebas.restapi.mapper.AddressMapper;
import com.jedisebas.restapi.mapper.PersonalDetailsMapper;
import com.jedisebas.restapi.repository.PersonalDetailsRepository;
import com.jedisebas.restapi.service.PersonalDetailsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class RestApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private AddressMapper addressMapper;

	@Spy
	private PersonalDetailsMapper mapper;

	@Mock
	private PersonalDetailsRepository repository;

	@InjectMocks
	private PersonalDetailsService service;

	@Before
	void setUp() {
		reset(addressMapper, repository);
	}

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	void personalDetailsCreate() throws Exception {
		PersonalDetailsDto personalDetailsDto = TestDataProvider.createProperlyPersonalDetailsDto();
		String ownJson = """
				{
				    "first_name": "Szymon",
				    "last_name": "Marciniak",
				    "email": "szymonmarciniak@gmail.com"
				    "address": {
				            "city": "Kalisz",
				            "street": "ostrowska",
				            "house_number": 22
				    }
				}
				""";

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/persons")
				.contentType(MediaType.APPLICATION_JSON)
				.content(ownJson)
		);

		PersonalDetailsDto testIfWorks = service.fetchPersonalDetails(1);

		assertEquals(personalDetailsDto.getEmail(), testIfWorks.getEmail());
	}
}
