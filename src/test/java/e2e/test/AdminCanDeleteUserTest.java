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
    @Epic(value = "Admin can delete user")
    @Feature(value= "Deleting users as Admin")
    @Story(value = "Admin can delete user with role admin")
    @Description(value = "Admin can delete user")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Admin can delete user")
    public void adminCanDeleteUser(){
        String email = "rashfeffdcfdd@gmail.com";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String emailAsAdmin = "rasehfffcfdfdAdmin@gmail.com";
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
