package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
public class Test01_GET {
    @Test
    void test_01(){
        //Deactivated the certificate check for this example for speed. In real implementation we would need control.
        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    void test_02(){
       given()
               .relaxedHTTPSValidation().get("https://reqres.in/api/users?page=2")
           .then()
               .body("data.id[0]",equalTo(7));
    }
}
