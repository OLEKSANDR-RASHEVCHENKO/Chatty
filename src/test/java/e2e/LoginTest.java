package e2e;

import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.testng.annotations.Test;
import untils.DataProviders;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    ProfilePage profilePage;

    private void loginTestMethod(String email, String password, String screenshotName, boolean negativeCase) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);
        if (negativeCase) {
            loginPage.waitForLoading();
            loginPage.takeLoginPageScreenshot(screenshotName);
        } else {
            homeblogPage = new HomeblogPage(app.driver);
            homeblogPage.waitForLoading();
            homeblogPage.takeScreenshotHeader();
        }
    }

    @Test
    public void userCanLoginWithValidData() {
        loginTestMethod("tatyanaskv@rambler.ru", "123456Start", null, false);
    }

    @Test
    public void userCanLoginEmptyEmail() {
        loginTestMethod(null, "123456Start", "login_without_email", true);
    }

    @Test
    public void userCanLoginWithEmptyPassword() {
        loginTestMethod("tatyanaskv@rambler.ru", null, "login_without_password", true);
    }

    @Test
    public void userCanLoginWithInvalidFormatEmail() {
        loginTestMethod("te.com", "qwereet", "login_invalid_emailFormat_too_short", true);
    }

    @Test
    public void userCanLoginWithInvalidFormat2Email() {
        loginTestMethod("1234567890123456789@com", "qwereet", "login_invalid_emailFormat_too_long", true);
    }


    @Test(description = "User can login with valid data as a user")
    public void userCanLogin() {
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();


    }

}





//    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
//    public void userCannotLogin(String email, String password, String caseName) {
//        loginPage = new LoginPage(app.driver);
//        loginPage.waitForLoading();
//        loginPage.login(email, password);
//
//        loginPage.waitForLoading();
//        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
//    }

