package integration.tests;

import integration.authorisation.LoginUser;
import org.testng.annotations.Test;

public class UserCanLoginTest {
    LoginUser loginUser;

    @Test(description = "User Can Login")
    public void userCanLogin() {
        String email = "tatyanaskv12@rambler.ru";
        String password = "123456Start";
        loginUser = new LoginUser();


    }
}
