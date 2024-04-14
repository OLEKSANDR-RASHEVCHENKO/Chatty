package integration.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class GetAllUsersAsAdmin extends ApiBase {
    public GetAllUsersAsAdmin(String token) {
        super(token);
    }

    @Step("Get all users")
    public String getAllUsersAsAdmin(int expectedStatusCode, int skip, int limit) {
        String endpoint = "/api/users";
        Response response = getAllPosts(skip, limit, expectedStatusCode, endpoint);
        return response.asString();
    }
}