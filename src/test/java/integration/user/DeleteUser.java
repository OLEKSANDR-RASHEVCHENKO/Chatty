package integration.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DeleteUser extends ApiBase {
    public DeleteUser(String token) {
        super(token);
    }

    @Step("Delete user by ID: {0}")
    public String deleteUser(String userId, int expectedStatusCode) {
        String endpoint = "/api/users/" + userId;
        Response response = deleteRequest(endpoint, expectedStatusCode);
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