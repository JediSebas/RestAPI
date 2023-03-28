package com.jedisebas.restapi.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CucumberSpringConfiguration {

    public static void setupConnection(final String path) {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = path;
        RestAssured.port = 8080;
    }
}
