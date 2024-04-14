package integration.tests;

import integration.authorisation.LoginUser;
import integration.userController.GetUser;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class UserCanLoginTest {
    LoginUser loginUser;
    GetUser getUser;

    @Test(description = "User Can Login")
    public void userCanLogin() {
        String email = "tatyanaskv12@rambler.ru";
        String password = "123456Start";
        loginUser = new LoginUser();
        String token = loginUser.login(email, password, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");
        System.out.println(userId);
    }

    @Test
    public void userCanNotLoginWithInvalidEmail() {
        String email = "teddy";
        String password = "123456Start";
        loginUser = new LoginUser();
        String token = loginUser.login(email, password, 400);
        getUser = new GetUser(token);
        getUser.getUser(401);
    }

    @Test
    public void userCanNotLoginWithInvalidPassword() {
        String email = "tatyanaskv12@rambler.ru";
        String password = "123";
        loginUser = new LoginUser();
        String token = loginUser.login(email, password, 401);
        getUser = new GetUser(token);
        getUser.getUser(401);


    }
}
