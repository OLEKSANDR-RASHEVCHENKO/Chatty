package e2e.test;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.test.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanLoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    private void loginTestMethod(String email,String password,String screenshotName,boolean negativeCase,boolean invalidData){
        loginPage=new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.loginInSystem(email,password);
        if (negativeCase) {
            if (invalidData) {
                loginPage.elementIsNotClickable();
            } else {
                loginPage.waiteForErrorMassage();
                // loginPage.takeLoginPageScreenshot(screenshotName);
            }
        } else {
            homePage = new HomePage(app.driver);
            homePage.waiteForVisibility();
        }
    }
    @Epic(value = "Login")
    @Feature(value= "User login")
    @Story(value = "User can login with role user")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void userCanLoginWithValidData(){
        loginTestMethod("chipsa14@gmail.com","Gazmanov1234",null,false,false);
    }
    @Test
    public void userCanNotLoginWithInvalidEmail() {
        loginTestMethod("chipsa13@gmail.com", "Gazmanov1234", "login_invalid_email", true,false);
    }
    @Test
    public void userCanNotLoginWithInvalidPassword() {
        loginTestMethod("chipsa12@gmail.com", "Gazmanov12345", "login_invalid_password", true,true
        );
    }
    @Test
    public void userCanNotLoginWithInvalidEmailAndPassword() {
        loginTestMethod("gmail@email.de", "Gazmanosdfv1234", "login_invalid_email_and_password", true,false);
    }
    @Test
    public void userCanNotLoginWithEmptyEmail() {
        loginTestMethod("", "Gazmanosdfv1234", "login_invalid_email_and_password", true,true);
    }
    @Test
    public void userCanNotLoginWithEmptyPassword() {
        loginTestMethod("gmail@email.de", "f", "login_invalid_email_and_password", true,true);
    }
}

