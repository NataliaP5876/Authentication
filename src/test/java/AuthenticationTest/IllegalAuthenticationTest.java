package AuthenticationTest;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class IllegalAuthenticationTest {


    @Test
    public void testAuthenticationNullPass () {
        JSONObject object = new JSONObject();
        object.put("login","admin");
        object.put("password","");
        ValidatableResponse response = AuthenticationTest.postJson(object.toString(), "https://diploma-courses.7bits.it/api/login",403);
        response.body("token",is(nullValue()));
    }

    @Test
    public void testAuthenticationTwinPass () {
        JSONObject object = new JSONObject();
        object.put("login","admin");
        object.put("password","adminadmin");
        AuthenticationTest.postJson(object.toString(), "https://diploma-courses.7bits.it/api/login",403).body("token",is(nullValue()));
    }
}
