package integration.user;

import integration.ApiBase;
import integration.schemas.PasswordReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PasswordUpdate extends ApiBase {
    public PasswordUpdate(String token) {
        super(token);
    }

    @Step("Change password for user ID: {0}")

    public String changePassword(String current, String newPassword, String confirmPassword, int expectedStatusCode) {
        String endpoint = "/api/user/password/update";
        Object body = passwordReq(current, newPassword, confirmPassword);
        Response response = putRequest(endpoint, expectedStatusCode, body);

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

    public PasswordReq passwordReq(String current, String newPassword, String confirmPassword) {
        PasswordReq passwordReq = new PasswordReq();
        passwordReq.setCurrentPassword(current);
        passwordReq.setNewPassword(newPassword);
        passwordReq.setConfirmPassword(confirmPassword);
        return passwordReq;
    }
}
