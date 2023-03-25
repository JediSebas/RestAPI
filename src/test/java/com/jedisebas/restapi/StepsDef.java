package com.jedisebas.restapi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;

public class StepsDef {

    private Response response;

    @When("a POST request is sent to {string}")
    public void aPostRequestIsSentTo(String url) {
        RestAssured.basePath = "http://localhost:8080/";
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", MediaType.APPLICATION_JSON);

        String json = """
                
                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

        response = request
                .body(json)
                .post(url);
    }
    
    @Then("the response status code should be {int} CREATED")
    public void theResponseStatusCodeShouldBeCreated(int code) {
        assertEquals(code, response.getStatusCode());
    }
}
