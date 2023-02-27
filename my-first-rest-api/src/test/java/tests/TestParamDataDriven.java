package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestParamDataDriven extends TestData{

    @Test(dataProvider = "DataForPost")
    public void testPost(String firstName, String lastName, int subjectId){
        baseURI="http://localhost:3000";
        StringBuilder request=new StringBuilder();
        request.append("{\"firstName\": \"").append(firstName)
                .append("\",\"lastName\": \"").append(lastName)
                .append("\",\"subjectId\": ").append(subjectId).append("}");
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @Parameters({"userId"})
    @Test
    public void testDelete(int userId){
        System.out.println(userId);
        baseURI="http://localhost:3000";
        when().
                delete("/users/"+userId).
                then().
                statusCode(200).
                log().all();
    }
}
