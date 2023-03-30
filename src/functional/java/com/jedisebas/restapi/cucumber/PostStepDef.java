package com.jedisebas.restapi.cucumber;

import com.jedisebas.restapi.constants.JsonRequestProvider;
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
        CucumberSpringConfigurationTest.setupConnection(path);

        final RequestSpecification request = RestAssured.given();

        response = request
                .contentType(ContentType.JSON)
                .body(JsonRequestProvider.EVENT_JSON)
                .post();
    }

    @Then("return {int} CREATE code")
    public void returnCREATECode(final int code) {
        assertEquals(code, response.getStatusCode());
    }
}
