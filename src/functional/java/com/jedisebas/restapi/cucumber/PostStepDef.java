package com.jedisebas.restapi.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostStepDef {

    private Response response;

    @When("post request is sent to {string}")
    public void postRequestIsSentTo(final String path) {
        final String json = """

                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = path;
        RestAssured.port = 8080;

        final RequestSpecification request = RestAssured.given();

        response = request
                .contentType(ContentType.JSON)
                .body(json)
                .post();
    }

    @Then("return {int} CREATE code")
    public void returnCREATECode(final int code) {
        assertEquals(code, response.getStatusCode());
    }
}
