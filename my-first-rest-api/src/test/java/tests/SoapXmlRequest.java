package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class SoapXmlRequest {
    @Test
    public void validateSoapXml() throws IOException {
        File file = new File("./SoapRequest/add.xml");
        FileInputStream fileStream = new FileInputStream(file);
        String requestApache = IOUtils.toString(fileStream, "UTF-8");
        baseURI="http://dneonline.com";
//        System.out.println("------File to String-----");
//        given().relaxedHTTPSValidation().
//                contentType("application/soap+xml").accept(ContentType.XML).
//                body(fileStream.toString()).
//        when().
//                post("/calculator.asmx").
//        then().statusCode(200);
        System.out.println("------Apache to request-----");
        given().relaxedHTTPSValidation().
                contentType("text/xml").accept(ContentType.XML).
                body(requestApache).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).
                log().all().
        and().body("//*:AddResult.text()",equalTo("3"));
    }
}
