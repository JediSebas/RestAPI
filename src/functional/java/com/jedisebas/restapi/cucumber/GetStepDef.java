package com.jedisebas.restapi.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetStepDef {

    private Response response;

    @When("get request is sent to {string}")
    public void getRequestIsSentTo(final String path) {
        CucumberSpringConfigurationTest.setupConnection(path);

        final RequestSpecification request = RestAssured.given();

        response = request
                .contentType(ContentType.JSON)
                .get();
    }

    @Then("return {int} OK code")
    public void returnOKCode(final int code) {
        assertEquals(code, response.getStatusCode());
    }
}
