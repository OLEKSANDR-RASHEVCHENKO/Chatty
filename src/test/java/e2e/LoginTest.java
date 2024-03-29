package e2e;

import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomeblogPage homeblogPage;

    @Test(description = "User can login with role user")
    public void userCanLogin(){
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();



    }
}
