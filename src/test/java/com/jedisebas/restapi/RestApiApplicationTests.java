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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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

	private static final String URL = "/v1/persons";

	@Test
	void personalDetailsCreate() throws Exception {
		final PersonalDetailsDto personalDetailsDto = TestDataProvider.createValidPersonalDetailsDto();

		final MvcResult mvcResult = getResult(post(URL), JsonRequestProvider.PERSONAL_DETAILS_JSON);

		final PersonalDetailsDto testIfWorks = service.fetchPersonalDetails(1);

		assertEquals(personalDetailsDto.getEmail(), testIfWorks.getEmail());
		assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void personalDetailsCreateBadRequest() throws Exception {
		final MvcResult mvcResult = getResult(post(URL), JsonRequestProvider.EMPTY_PERSONAL_DETAILS_JSON);

		assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void personalDetailsUpdate() throws Exception {
		final MvcResult mvcResult = getResult(put(URL, 1), JsonRequestProvider.PERSONAL_DETAILS_JSON2);

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void personalDetailsUpdateBadRequest() throws Exception {
		final MvcResult mvcResult = getResult(put(URL, 1), JsonRequestProvider.EMPTY_PERSONAL_DETAILS_JSON);

		assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	void personalDetailsUpdateNotFound() throws Exception {
		final MvcResult mvcResult = getResult(put(URL, 5), JsonRequestProvider.PERSONAL_DETAILS_JSON2);

		assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
	}

	private MvcResult getResult(MockHttpServletRequestBuilder request, String json) throws Exception {
		return mockMvc.perform(request
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)).andReturn();
	}

	private MockHttpServletRequestBuilder get(String url) {
		return MockMvcRequestBuilders.get(url);
	}

	private MockHttpServletRequestBuilder get(String url, int id) {
		return get(url + "/" + id);
	}

	private MockHttpServletRequestBuilder post(String url) {
		return MockMvcRequestBuilders.post(url);
	}

	private MockHttpServletRequestBuilder put(String url, int id) {
		return MockMvcRequestBuilders.put(url + "/" + id);
	}
}
