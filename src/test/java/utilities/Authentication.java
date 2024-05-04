package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken() {
/*        Map<String, String> bodyMap = new HashMap<>();

        if (email == null) {
            bodyMap.put("email", "jasonsteel@gmail.com");
            bodyMap.put("password", "Jason.123");
        } else {
            bodyMap.put("email", email);
            bodyMap.put("password", "Password.123");
        }*/


        String strJson = """
                {
                    "email" : "Test2@fake.com",
                    "password" : "myNewPassword"
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
