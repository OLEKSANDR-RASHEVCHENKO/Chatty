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
    private void feedbackTestMethod(String email,String password,String name ,String emailForSend,String description,String screenshotName,boolean negativeCase){
        loginPage=new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.loginInSystem(email,password);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.clickOnOneFromHeaderMenu(Header_menu.Contact);
        contactPage = new ContactPage(app.driver);
        contactPage.waiteForLoading();
        contactPage.sendMessage(name,emailForSend,description);
        if (negativeCase){
            contactPage.waiteForInvalidMassage();
        }else {
            contactPage.waiteForSuccessfullyMassage();
        }
    }
    @Epic(value = "Login")
    @Feature(value= "User login")
    @Story(value = "User can login with role admin")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void userCanSendFeedback(){
        feedbackTestMethod("chipsa14@gmail.com","Gazmanov1234","Alex","chipsa14@gmail.com","Hallo I'am Alex",null,false);
    }
    @Epic(value = "Login")
    @Feature(value= "User login")
    @Story(value = "User can login with role admin")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void userCanNotSendFeedbackWithInvalidEmail(){
        feedbackTestMethod("chipsa14@gmail.com","Gazmanov1234","Alex","chipsa14","Hallo I'am Alex",null,true);
    }

}
