package integration.post;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class GetDraftPosts extends ApiBase {
    public GetDraftPosts(String token) {
        super(token);
    }

    @Step("Get draft Posts")
    public String getDraftsPosts(int expectedStatusCode) {
        String endpoint = "/api/posts/drafts";
        Response response = getRequest(endpoint, expectedStatusCode);
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