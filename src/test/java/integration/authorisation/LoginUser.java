package integration.authorisation;

import integration.ApiBase;
import integration.schemas.RegisterReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class LoginUser extends ApiBase {
    RegisterReq registerReq;
    Response response;

    @Step("Login by Email and Password : {email},{password}")
    public String login(String email, String password, int expectedStatusCode) {
        String endPoint = "/api/auth/login";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);

        response = postRequest(endPoint, expectedStatusCode, body);

    }
}
