package com.jedisebas.restapi.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty" },
        features = { "src/functional/resources" },
        glue = { "com/jedisebas/restapi/cucumber" }
)
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CucumberSpringConfigurationTest {

    public static void setupConnection(final String path) {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = path;
        RestAssured.port = 8080;
    }
}
