package integration.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.PasswordReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PasswordUpdate extends ApiBase {
    public PasswordUpdate(String token) {
        super(token);
    }

    @Step("Change password for user ID: {0}")

    public String changePassword(String userId, PasswordReq passwordReq, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/user/password/update";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(passwordReq);
        Response response = putRequest(endpoint, expectedStatusCode, jsonRequest);

        switch (response.getStatusCode()) {
            case 200:
                return response.asString();
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + " - " + response.asString();
        }

    }
}