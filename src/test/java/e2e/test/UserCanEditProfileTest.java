package e2e.test;

import com.github.javafaker.Faker;
import e2e.enums.DropDownMenu;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.YourProfilePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanEditProfileTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    YourProfilePage yourProfilePage;
    Faker faker;
    @Epic(value = "Edit profile")
    @Feature(value= "User can edite profile")
    @Story(value = "User can edit profile ")
    @Description(value = "User can edite profile")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "User can edit profile")
    public void user(){
        String email = "chipsa15@gmail.com";
        String password = "Gazmanov1234";
        faker = new Faker();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        String birthDate = "14.05.1999";
        String phone = "+49159068135";
        loginPage = new LoginPage(app.driver);
        loginPage.loginInSystem(email, password);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnOneFromDropDownMenu(DropDownMenu.Your_Profile);
        yourProfilePage = new YourProfilePage(app.driver);
        yourProfilePage.waitForLoading();
        yourProfilePage.updateUserProfile(name,surname,birthDate,phone);
        yourProfilePage.goToHomePage();
        homePage.waiteForVisibility();
        String userNameOnHomePage=homePage.getUserNameFromHomePage();
        Assert.assertEquals(userNameOnHomePage,name);
    }
}
