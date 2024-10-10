package integration.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.ApiBase;
import integration.schemas.PostCreateReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreatePost extends ApiBase {
    public CreatePost(String token) {
        super(token);
    }

    @Step("Create post")
    public String createPost(String title, String description, String bodyReq, String imageUrl, String publishDate, boolean draft, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/posts";
        Object body = postCreating(title, description, bodyReq, imageUrl, publishDate, draft);
        Response response = postRequest(endpoint, expectedStatusCode, body);
        switch (response.getStatusCode()) {
            case 201:
                return response.asString();
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            case 404:
                return "Not Found: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + ". Response: " + response.asString();
        }
    }

    public PostCreateReq postCreating(String title, String description, String body, String imageUrl, String publishDate, boolean draft) {
        PostCreateReq postCreateReq = new PostCreateReq();
        postCreateReq.setTitle(title);
        postCreateReq.setDescription(description);
        postCreateReq.setBody(body);
        postCreateReq.setImageUrl(imageUrl);
        postCreateReq.setPublishDate(publishDate);
        postCreateReq.setDraft(draft);
        return postCreateReq;
    }
}