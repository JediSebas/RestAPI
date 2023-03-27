package com.jedisebas.restapi;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class MyStepdefs {

    private Response response;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Given("a GET request to {string}")
    public void aGETRequestTo(String url) {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    @Then("the response status code should be {int} OK")
    public void theResponseStatusCodeShouldBeOK(int code) {
        assertEquals(code, response.getStatusCode());
    }
}
