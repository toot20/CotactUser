package Homework16;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class GetContact extends ContactListBaseUrl {
    @Test
    void GetContactTest() {
        //Set the url
        spec.pathParams("first", "contacts");

        String strJson = """
                {
                 "firstName": "Test",
                 "lastName": "User",
                 "birthdate": "1970-01-01",
                 "email": "atikah@fake.com",
                 "phone": "8005555555",
                 "street1": "1 Main St.",
                 "street2": "Apartment A",
                 "city": "Anytown",
                 "stateProvince": "KS",
                 "postalCode": "12345",
                 "country": "USA"
                }""";

        ContactPojo expectedData = convertJsonToJava(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("{first}");
        response.prettyPrint();
    }
}
