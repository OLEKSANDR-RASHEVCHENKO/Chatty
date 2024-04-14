package integration.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.UpdatePostReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UpdatePost extends ApiBase {
    public UpdatePost(String token) {
        super(token);
    }

    @Step("Update post by postID: {0}")
    public String updatePost(String postId, UpdatePostReq updatePostReq, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/posts/" + postId;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(updatePostReq);
        Response response = putRequest(endpoint, expectedStatusCode, jsonRequestBody);
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