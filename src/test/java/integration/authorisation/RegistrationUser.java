package integration.authorisation;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class RegistrationUser extends ApiBase {
    Response response;
    RegistrationUser registrationUser;

    @Step("Registration via api: {email}, {password}")
    public String registration(String email, String password, String confirmPassword, String role, int code) {
        String endpoint = "/api/auth/register";
        LinkedHashMap<String, String> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        body.put("confirmPassword", confirmPassword);
        body.put("role", role);

        response = postRequest(endpoint, code, body);
        int statusCode = response.statusCode();


    }

}
