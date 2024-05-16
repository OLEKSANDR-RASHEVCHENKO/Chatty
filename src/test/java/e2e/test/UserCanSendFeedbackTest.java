package e2e.test;

import e2e.enums.Header_menu;
import e2e.pages.ContactPage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanSendFeedbackTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;

    private void feedbackTestMethod(String email, String password, String name, String emailForSend, String description, String screenshotName, boolean negativeCase) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.loginInSystem(email, password);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.clickOnOneFromHeaderMenu(Header_menu.Contact);
        contactPage = new ContactPage(app.driver);
        contactPage.waiteForLoading();
        contactPage.takeHeaderScreenshotOnContactPage("ScreenshotOnFeedbackPage");
        contactPage.sendMessage(name, emailForSend, description);
        if (negativeCase) {
            contactPage.waiteForInvalidMassage();
        } else {
            contactPage.waiteForSuccessfullyMassage();
        }
    }

    @Feature(value = "User send feedback")
    @Story(value = "User can sending feedback")
    @Description(value = "User can send feedback")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User can send feedback")
    public void userCanSendFeedback() {
        feedbackTestMethod("chipsa14@gmail.com", "Gazmanov1234", "Alex", "chipsa14@gmail.com", "Hallo I'am Alex", null, false);
    }

    @Feature(value = "User  can cot send feedback")
    @Story(value = "User can  not sending of feedback")
    @Description(value = "User can not send feedback")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User can  not send feedback")
    public void userCanNotSendFeedbackWithInvalidEmail() {
        feedbackTestMethod("chipsa14@gmail.com", "Gazmanov1234", "Alex", "chipsa", "Hallo I'am Alex", null, true);
    }

}
