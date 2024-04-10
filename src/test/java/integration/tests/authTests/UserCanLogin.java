package integration.tests.authTests;

import integration.authApi.AuthApi;
import integration.user.GetUser;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class UserCanLogin {
    AuthApi authApi;
    GetUser getUser;

    @Epic(value = "Login")
    @Feature(value = "User login")
    @Story(value = "User can login with role user")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void userCanLoginWithValidData() {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov1234";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");
        System.out.println(userId);
    }

    @Test
    public void userCanNotLoginWithInvalidEmail() {
        String email = "rashevc88495f@gmail.c";
        String password = "Gazmanov1234";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 400);
        getUser = new GetUser(token);
        getUser.getUser(401);
    }

    @Test
    public void userCanNotLoginWithInvalidPassword() {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov123";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 401);
        getUser = new GetUser(token);
        getUser.getUser(401);
    }
}