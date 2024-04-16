package integration.tests.authTest;

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
    @Test(description = "User Can Login with valid data")
    public void userCanLoginWithValidData() {
        String email = "alexberr9501@gmail.com";
        String password = "123qwert";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");
        System.out.println(userId);
    }

    @Epic(value = "Login")
    @Feature(value = "User can't login")
    @Story(value = "User can login with role user")
    @Description(value = "User can't  login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "user can't Login with Invalid Email")
    public void userCanNotLoginWithInvalidEmail() {
        String email = "alexberr95@gmail.com";
        String password = "123qwert";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 400);
        getUser = new GetUser(token);
        getUser.getUser(401);
    }

    @Epic(value = "Login")
    @Feature(value = "User can't login")
    @Story(value = "User can login with role user")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "user can't Login with Invalid Password")
    public void userCanNotLoginWithInvalidPassword() {
        String email = "alexberr9501@gmail.com";
        String password = "123qwerty";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 401);
        getUser = new GetUser(token);
        getUser.getUser(401);
    }

}