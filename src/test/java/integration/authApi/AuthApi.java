package integration.authApi;

import integration.ApiBase;
import integration.schemas.LoginReq;
import integration.schemas.RegisterReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AuthApi extends ApiBase {
    Response response;

    @Step("Registration user")
    public String registration(String email, String password, String confirmPassword, String role, int expectedStatusCode) {
        String endPoint = "/api/auth/register";
        Object body = registrationDataInput(email, password, confirmPassword, role);
        Response response = postRequest(endPoint, expectedStatusCode, body);
        int statusCode = response.statusCode();

        if (statusCode == expectedStatusCode) {
            return "User registered successfully";
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to register user: " + errorMessage;
        }
    }

    public RegisterReq registrationDataInput(String email, String password, String confirmPassword, String role) {
        RegisterReq registerReq = new RegisterReq();
        registerReq.setEmail(email);
        registerReq.setPassword(password);
        registerReq.setConfirmPassword(confirmPassword);
        registerReq.setRole(role);
        return registerReq;
    }

    public LoginReq loginIntoSystem(String email, String password) {
        LoginReq loginReq = new LoginReq();
        loginReq.setEmail(email);
        loginReq.setPassword(password);
        return loginReq;
    }

    @Step("Login by Email and Password : {email},{password}")
    public String login(String email, String password, int expectedStatusCode) {
        String endPoint = "/api/auth/login";
        Object body = loginIntoSystem(email, password);
        response = postRequest(endPoint, expectedStatusCode, body);
        int statusCode = response.statusCode();

        if (statusCode == expectedStatusCode) {
            String refreshToken = response.jsonPath().getString("refreshToken");
            return refreshToken;
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to login: " + errorMessage;
        }
    }
}

