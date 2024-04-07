package e2e;

import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomeblogPage homeblogPage;

    @Test(description = "User can login with valid data as a user")
    public void userCanLogin(){
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
    }

    @Test(description = "User can not login with invalid data as a user")
            public void userCanNotLoginWithInvalidEmail(){
        String email = "tatyanaskv@rambler123.ru";
        String password = "123456Start";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
    }
}
