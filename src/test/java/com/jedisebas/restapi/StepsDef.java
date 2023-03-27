package com.jedisebas.restapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@AllArgsConstructor
public class StepsDef {

    private final MockMvc mockMvc;
    private MvcResult mvcResult;

    @Given("a POST request to {string}")
    public void aPostRequestIsSentTo(String url) throws Exception {
        String json = """

                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();
    }
    
    @Then("the response status code should be {int} CREATED")
    public void theResponseStatusCodeShouldBeCreated(int code) {
        assertEquals(code, mvcResult.getResponse().getStatus());
    }
}
