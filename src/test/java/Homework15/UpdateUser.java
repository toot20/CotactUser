package Homework15;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import pojos.UserResponsePojo;
import utilities.ObjectMapperUtils;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class UpdateUser extends ContactListBaseUrl {


    @Test
    public void updateUserTest() {
        //Set the url
        spec.pathParams("first", "users", "second", "me");

        //Set the expected data
        String strJson = """
                {
                "firstName": "Atikah",
                "lastName": "Saeed",
                "email": "atikah@fake.com",
                "password": "myPassword"
                }""";

        UserPojo expectedData = convertJsonToJava(strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //Do assertion
        UserResponsePojo actualData = convertJsonToJava(response.asString(), UserResponsePojo.class);
        System.out.println("actualData = " + actualData);
    }
}


