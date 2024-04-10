package integration.post;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class GetPostByPostId extends ApiBase {
    public GetPostByPostId(String token) {
        super(token);
    }

    @Step("Get post by postID: {0}")
    public String getPostByPostId(String postId, int expectedStatusCode) {
        String endPoint = "/api/posts/" + postId;
        Response response = getRequest(endPoint, expectedStatusCode);
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

