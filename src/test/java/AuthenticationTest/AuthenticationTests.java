package AuthenticationTest;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class AuthenticationTests {

    public static ValidatableResponse postJson(
            JSONObject request, String url, int status
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
        postJson(object, "https://diploma-courses.7bits.it/login",200).body("token",is(notNullValue()));
    }

    @Test
    public void testAuthenticationNullPass () {
        JSONObject object = new JSONObject();
        object.put("login","admin");
        object.put("password","");
        ValidatableResponse response = postJson(object, "https://diploma-courses.7bits.it/login",200);
        response.body("token",is(nullValue()));
    }

    @Test
    public void testAuthenticationTwinPass () {
        JSONObject object = new JSONObject();
        object.put("login","admin");
        object.put("password","adminadmin");
        postJson(object, "https://diploma-courses.7bits.it/login",200).body("token",is(nullValue()));
    }
}
