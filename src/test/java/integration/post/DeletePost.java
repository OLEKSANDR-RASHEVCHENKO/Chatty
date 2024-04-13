package integration.post;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DeletePost extends ApiBase {
    public DeletePost(String token) {
        super(token);
    }

    @Step("Delete post by postID: {0}")
    public String deletePost(String postId, int expectedStatusCode) {
        String endPoint = "/api/posts/" + postId;
        Response response = deleteRequest(endPoint, expectedStatusCode);
        switch (response.getStatusCode()) {
            case 204:
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
