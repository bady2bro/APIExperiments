package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestsGet {
    @Test
    public void testOne(){
        given().relaxedHTTPSValidation().
                    header("Content-Type", "application/json").
                    param("id","96").
                get("https://reqres.in/api/users").
                then().
                    statusCode(200).
                    body("data.id",equalTo(96)).
                    body("data.first_name",equalTo("Michael")).
                    log().all();
    }
}
