package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestJsonSchema {

    @Test
    public void validateSchema(){
        baseURI="http://localhost:3000";
        given().get("/users").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
