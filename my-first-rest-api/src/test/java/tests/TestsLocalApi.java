package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class TestsLocalApi {
    @Test
    public void testGet(){
        baseURI="http://localhost:3000";
        given().param("firstName","Adrian").
                get("/users").
        then().
                statusCode(200).
        log().all();
    }

    @Test
    public void testPost(){
        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body("{\"firstName\": \"Adrian\",\"lastName\": \"P\",\"subjectId\": 2}").
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }

    @Test
    public void testPut(){
        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body("{\"firstName\": \"Adrian\",\"lastName\": \"Pintea\",\"subjectId\": 2}").
        when().
                put("/users/4").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete(){
        baseURI="http://localhost:3000";
        when().
                delete("/users/4").
        then().
                statusCode(200).
                log().all();
    }

    public static void main(String[] args){
        Parent child = new Child();
        child.print();
        Parent parent = new Parent();
        Child newChild = (Child) child;
        newChild.print();
        newChild.printMore();
        List<String> list = List.of("a","d","f");
    }
}
