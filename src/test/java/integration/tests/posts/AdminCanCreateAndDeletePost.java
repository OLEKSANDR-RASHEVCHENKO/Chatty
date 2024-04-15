package integration.tests.posts;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.post.CreatePost;
import integration.post.DeletePost;
import integration.post.GetPostByPostId;
import integration.schemas.PostCreateReq;
import integration.uploadPhoto.UploadPhoto;
import integration.user.GetUser;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AdminCanCreateAndDeletePost {

    AuthApi authApi;
    GetUser getUser;
    UploadPhoto uploadPhoto;
    CreatePost createPost;
    GetPostByPostId getPostByPostId;
    DeletePost deletePost;

    @Epic(value = "Create post")
    @Feature(value = "Creating post")
    @Story(value = "Admin can create post with role admin")
    @Description(value = "Admin can create post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Admin can create post")
    public void adminCanCreatePost() throws JsonProcessingException {
        String email = "alewwx@gmail.com";
        String password = "Gazmanov1234";
        File filePath = new File("src/test/java/integration/photo/squirrel_PNG15782.png");

        String title = "hallo world";
        String description = "djfjdfj";
        String body = "djfjdjfjd";

        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);

        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);

        uploadPhoto = new UploadPhoto(token);
        String imageURL = uploadPhoto.uploadImage(filePath, 201);

        PostCreateReq postCreateReq = new PostCreateReq();
        postCreateReq.setTitle(title);
        postCreateReq.setDescription(description);
        postCreateReq.setBody(body);
        postCreateReq.setImageUrl(imageURL);

        createPost = new CreatePost(token);
        String response = createPost.createPost(postCreateReq, 201);
        JsonPath jsonPath = new JsonPath(response);
        String postId = jsonPath.getString("id");

        getPostByPostId = new GetPostByPostId(token);
        String getResponse = getPostByPostId.getPostByPostId(postId, 200);
        JsonPath postJson = new JsonPath(getResponse);
        String postTitle = postJson.getString("title");
        String postDescription = postJson.getString("description");
        String postBody = postJson.getString("body");
        String postImageUrl = postJson.getString("imageUrl");

        Assert.assertEquals(title, postTitle);
        Assert.assertEquals(description, postDescription);
        Assert.assertEquals(body, postBody);
        Assert.assertEquals(imageURL, postImageUrl);

        deletePost = new DeletePost(token);
        deletePost.deletePost(postId, 204);

        getPostByPostId.getPostByPostId(postId, 404);

    }
}