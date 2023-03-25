package com.jedisebas.restapi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
public class StepsDef {

    @Autowired
    private MockMvc mockMvc;

    private MvcResult mvcResult;

    @When("a POST request is sent to {string}")
    public void a_post_request_is_sent_to(String url) throws Exception {
        String ownJson = """
                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ownJson))
                .andReturn();
    }
    
    @Then("the response status code should be {int} CREATED")
    public void the_response_status_code_should_be_created(Integer code) {
        assertEquals(code, (Integer) mvcResult.getResponse().getStatus());
    }
}
