package integration.uploadPhoto;

import integration.ApiBase;
import io.restassured.response.Response;

import java.io.File;


public class UploadPhoto extends ApiBase {
    public UploadPhoto(String token) {
        super(token);
    }

    public String uploadImage(File imageFile, int expectedStatusCode) {
        String endPoint = "/api/images";
        Response response = uploadImageRequest(endPoint, imageFile, expectedStatusCode);
        if (response.statusCode() == expectedStatusCode) {
            return response.jsonPath().getString("imageUrl");
        } else {
            String errorMessage = response.jsonPath().getString("message");
            return "Failed to upload image: " + errorMessage;
        }
    }
}