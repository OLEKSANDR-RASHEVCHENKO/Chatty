package integration.tests.posts;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.post.CreatePost;
import integration.post.DeletePost;
import integration.post.GetPostByPostId;
import integration.uploadPhoto.UploadPhoto;
import integration.user.GetUser;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UserCanCreateAndDeletePost {
    AuthApi authApi;
    GetUser getUser;
    UploadPhoto uploadPhoto;
    CreatePost createPost;
    GetPostByPostId getPostByPostId;
    DeletePost deletePost;

    @Epic(value = "Create post")
    @Feature(value = "Creating post")
    @Story(value = "User can create post with role user")
    @Description(value = "User can create post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can create post")
    public void userCanCreatePost() throws JsonProcessingException {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov1234";
        File filePath = new File("src/test/java/integration/photo/vinni-pukh-v-png.png");

        String title = "hallo world";
        String description = "djfjdfj";
        String body = "djfjdjfjd";
        boolean draft = false;
        String publishData = "";

        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);

        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");

        uploadPhoto = new UploadPhoto(token);
        String imageURL = uploadPhoto.uploadImage(filePath, 201);
        System.out.println(imageURL);

        createPost = new CreatePost(token);
        String response = createPost.createPost(title, description, body, imageURL, publishData, draft, 201);
        JsonPath jsonPath = new JsonPath(response);
        String postId = jsonPath.getString("id");

        getPostByPostId = new GetPostByPostId(token);
        getPostByPostId.getPostByPostId(postId, 200);
        String postTitle = jsonPath.getString("title");
        String postDescription = jsonPath.getString("description");
        String postBody = jsonPath.getString("body");
        String postImageUrl = jsonPath.getString("imageUrl");

        Assert.assertEquals(title, postTitle);
        Assert.assertEquals(description, postDescription);
        Assert.assertEquals(body, postBody);
        Assert.assertEquals(imageURL, postImageUrl);

        deletePost = new DeletePost(token);
        deletePost.deletePost(postId, 204);

        getPostByPostId.getPostByPostId(postId, 404);
    }
}
