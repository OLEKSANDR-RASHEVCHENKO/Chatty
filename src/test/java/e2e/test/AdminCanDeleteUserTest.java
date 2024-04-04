package e2e.test;

import com.github.javafaker.Faker;
import e2e.enums.DropDownMenu;
import e2e.pages.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AdminCanDeleteUserTest extends TestBase {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    AdminPanel adminPanel;
    PostPage postPage;
    Faker faker;
    @Epic(value = "Login")
    @Feature(value= "User login")
    @Story(value = "User can login with role admin")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void adminCanDeleteUser(){
        String email = "rashfefffdd@gmail.com";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String emailAsAdmin = "rasehfffffdAdmin@gmail.com";
        String passwordAsAdmin = "Gazmanov1234";
        String confirmPasswordAsAdmin = "Gazmanov1234";
        loginPage=new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.clickToRegistration();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waiteForLoading();
        registrationPage.registrationAsUser(email,password,confirmPassword);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnOneFromDropDownMenu(DropDownMenu.Logout);


        loginPage.waitForVisibility();
        loginPage.clickToRegistration();
        registrationPage.waiteForLoading();
        registrationPage.registrationAsAdmin(emailAsAdmin,passwordAsAdmin,confirmPasswordAsAdmin);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnOneFromDropDownMenu(DropDownMenu.AdminPanel);
        adminPanel = new AdminPanel(app.driver);
        adminPanel.waitForLoading();
        adminPanel.searchUser(email);
        adminPanel.waitForUser();
        adminPanel.deleteUser();
        adminPanel.userIsNotVisible();

    }
}
