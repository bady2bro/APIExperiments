package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class TestsPost {
    @Test
    public void postOne() throws JsonProcessingException {
        Map<String, Object> body= new HashMap<>();
        body.put("name","Adi");
        body.put("job","plebe");
        String json = new ObjectMapper().writeValueAsString(body);
        System.out.println("The POST body is:\n"+json);
        given().relaxedHTTPSValidation().body(json).contentType(ContentType.JSON).accept(ContentType.JSON).
        when().
            post("https://reqres.in/api/users/2").
        then().statusCode(201).log().all();

    }

    @Test
    public void putOne() throws JsonProcessingException {
        Map<String, Object> body= new HashMap<>();
        body.put("name","Adi");
        body.put("job","god");
        String json = new ObjectMapper().writeValueAsString(body);
        System.out.println("The POST body is:\n"+json);
        given().relaxedHTTPSValidation().body(json).contentType(ContentType.JSON).accept(ContentType.JSON).
                when().
                put("https://reqres.in/api/users/447").
                then().log().all();
        given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON).
                get("https://reqres.in/api/users/447").
                then().statusCode(200).log().all();
    }
}
