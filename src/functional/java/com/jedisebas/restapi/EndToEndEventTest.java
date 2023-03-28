package com.jedisebas.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        final String json = """

                {
                    "title": "Tech3camp",
                    "date": "2023-03-23 17:35:00",
                    "description": "Lorem ipsum dolor sentio amo is"
                }
                """;

        final Response response = request
                .contentType(ContentType.JSON)
                .body(json)
                .post();

        assertEquals(201, response.getStatusCode());

        final String jsonResult = response.getBody().asString();

        createdId = JsonPath.from(jsonResult).get("id");
    }

    @Test
    void givenGetRequest() {
        RestAssured.basePath = "/" + createdId;

        final Response response = request
                .contentType(ContentType.JSON)
                .get();

        assertEquals(200, response.getStatusCode());
    }
}
