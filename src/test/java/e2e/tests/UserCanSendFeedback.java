package e2e.tests;

import e2e.pages.ContactPage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanSendFeedback extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    private void feedbackTestMethod(String email,String password,String name ,String emailForSend,String description,boolean negativeCase){
        loginPage=new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.loginInSystem(email,password);
        homePage = new HomePage(app.driver);
        homePage.waitForVisibility();
        homePage.clickContact();
        contactPage = new ContactPage(app.driver);
        contactPage.waitForLoading();
        contactPage.sendFeedback(name,emailForSend,description);
        if (negativeCase){
            contactPage.waitForInvalidMessage();
        }else {
            contactPage.waitForSuccessfullyMessage();
        }
    }

    @Epic(value = "User can send feedback")
    @Feature(value= "User send feedback")
    @Story(value = "User can sending feedback")
    @Description(value = "User can send feedback")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User can send feedback")
    public void userCanSendFeedback(){
        feedbackTestMethod("alexberr9501@gmail.com","123qwert","Alex","alexberr9501@gmail.com","Hello I'm Alex",false);
    }
}
