package Homework15;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class CreateUser extends ContactListBaseUrl {
    @Test
    void postUserTest() {
        //Set the url
        spec.pathParams("first", "users");

        String strJson = """
                {
                "firstName": "Test",
                "lastName": "User",
                "email": "atikah@fake.com",
                "password": "myPassword"
                }""";

        UserPojo expectedData = convertJsonToJava(strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

    }
}
