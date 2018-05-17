package AuthenticationTest;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationTest {

    public static ValidatableResponse postJson(
            String request, String url, int status
    ) {
        return given()
                .auth()
                .preemptive()
                .basic("admin", "admin123")
                .contentType(JSON)
                .body(request)
                .when()
                .post(url)
                .then()
                .statusCode(status);
    }


    @Test
    public void testAuthentication () {
        JSONObject object = new JSONObject();
        object.put("login","admin");
        object.put("password","admin");
        ValidatableResponse response  = postJson(object.toString(), "https://diploma-courses.7bits.it/api/login",200);
        response.body("token",is(notNullValue()));
    }


}
