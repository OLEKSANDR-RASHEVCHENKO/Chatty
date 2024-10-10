package integration.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.ApiBase;
import integration.schemas.UpdatePostReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UpdatePost extends ApiBase {
    public UpdatePost(String token) {
        super(token);
    }

    @Step("Update post by postID: {0}")
    public String updatePost(String title, String description, String bodyPost, String imageUrl, String draft, String postId, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/posts/" + postId;
        Object body = updatingPosts(title, description, bodyPost, imageUrl, draft);
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

    public UpdatePostReq updatingPosts(String title, String description, String body, String imageUrl, String draft) {
        UpdatePostReq updatePostReq = new UpdatePostReq();
        updatePostReq.setTitle(title);
        updatePostReq.setDescription(description);
        updatePostReq.setBody(body);
        updatePostReq.setImageUrl(imageUrl);
        updatePostReq.setDraft(draft);
        return updatePostReq;
    }
}

