package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken() {

        String strJson = """
                {
                    "email" : "atikah@fake.com",
                    "password" : "myPassword"
                }
                """;

        Response response = given()
                .body(strJson)
                .contentType(ContentType.JSON)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
//        response.prettyPrint();

        return response.jsonPath().getString("token");
    }
}
