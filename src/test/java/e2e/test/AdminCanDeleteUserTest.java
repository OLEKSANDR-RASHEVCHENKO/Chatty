package e2e.test;

import com.github.javafaker.Faker;
import e2e.enums.DropDownMenu;
import e2e.pages.AdminPanel;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.RegistrationPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AdminCanDeleteUserTest extends TestBase {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    AdminPanel adminPanel;
    Faker faker;

    @Feature(value = "Deleting users as Admin")
    @Story(value = "Admin can delete user with role admin")
    @Description(value = "Admin can delete user")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Admin can delete user")
    public void adminCanDeleteUser() {
        faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + "@gmail.com";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String emailAsAdmin = faker.name().firstName().toLowerCase() + "@gmail.com";
        String passwordAsAdmin = "Gazmanov1234";
        String confirmPasswordAsAdmin = "Gazmanov1234";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.takeHeaderScreenshotOnLoginPage("HeaderOnLoginPage");
        loginPage.clickToRegistration();
        registrationPage = new RegistrationPage(app.driver);
        registrationPage.waiteForLoading();
        registrationPage.registrationAsUser(email, password, confirmPassword);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnOneFromDropDownMenu(DropDownMenu.Logout);

        loginPage.waitForVisibility();
        loginPage.clickToRegistration();
        registrationPage.waiteForLoading();
        registrationPage.registrationAsAdmin(emailAsAdmin, passwordAsAdmin, confirmPasswordAsAdmin);
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
