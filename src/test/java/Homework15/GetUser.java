package Homework15;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import pojos.UserResponsePojo;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class GetUser extends ContactListBaseUrl {

    @Test
    public void verifyTheUserViaAPIRequest() {

        //Set the url
        //https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first", "users", "second", "me");

        //Set the expected data
        String strJson = """
                {
                "firstName": "Test",
                "lastName": "User",
                "email": "atikah@fake.com",
                "password": "myPassword"
                }""";

        UserPojo expectedData = convertJsonToJava(strJson, UserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //Do assertion
        UserResponsePojo actualData = convertJsonToJava(response.asString(), UserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getEmail(), expectedData.getEmail());

    }
}
