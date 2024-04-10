package integration.post;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class GetAllPosts extends ApiBase {
    public GetAllPosts(String token) {
        super(token);
    }

    @Step("Get all posts")
    public String getAllPosts(int expectedStatusCode, int skip, int limit) {
        String endPoint = "/api/posts";

        Response response = getAllPosts(skip, limit, expectedStatusCode, endPoint);
        return response.asString();
    }

}
