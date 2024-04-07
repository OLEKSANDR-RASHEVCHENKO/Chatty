package e2e;

import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;
import untils.DataProviders;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomeblogPage homeblogPage;


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

    @Test(description = "User can login with valid data as a user")
    public void userCanLogin(){
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
    }

//    @Test(description = "User can not login with invalid data as a user")
//            public void userCanNotLoginWithInvalidEmail(){
//        String email = "tatyanaskv@rambler123.ru";
//        String password = "123456Start";
//
//        loginPage = new LoginPage(app.driver);
//        loginPage.login(email, password);
//
//        homeblogPage = new HomeblogPage(app.driver);
//        homeblogPage.waitForLoading();
//    }


    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void userCannotLogin(String email, String password, String caseName) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
    }


    @Test
    public void userCanLoginWithValidData() {
        loginTestMethod("newtest@gmail.com", "newtest@gmail.com", null, false);
    }

    @Test
    public void userCanLoginWithInvalidEmail() {
        loginTestMethod("teddy@gmail.com", "123456Start", "login_invalid_email", true);
    }

    @Test
    public void userCanLoginWithInvalidPassword() {
        loginTestMethod("tatyanaskv@rambler.ru", "12345", "login_invalid_password", true);
    }

    @Test
    public void userCanLoginWithInvalidEmailAndPassword() {
        loginTestMethod("teddy.com", "qwereet", "login_invalid_email_and_password", true);
    }
}

