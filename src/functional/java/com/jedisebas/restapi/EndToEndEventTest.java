package com.jedisebas.restapi;

import com.jedisebas.restapi.constants.JsonRequestProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class EndToEndEventTest {

    private RequestSpecification request;
    private int createdId;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost/v1/events";
        RestAssured.basePath = "";
        RestAssured.port = 8080;
        request = RestAssured.given();
    }

    @Test
    void givenPostRequest() {
        final Response response = request
                .contentType(ContentType.JSON)
                .body(JsonRequestProvider.eventJson)
                .post();

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());

        final String jsonResult = response.getBody().asString();

        createdId = JsonPath.from(jsonResult).get("id");
    }

    @Test
    void givenGetRequest() {
        RestAssured.basePath = "/" + createdId;

        final Response response = request
                .contentType(ContentType.JSON)
                .get();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
}
