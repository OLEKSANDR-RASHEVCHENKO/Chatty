package e2e_Teti;

import com.github.javafaker.Faker;
import e2e_Teti.pages.*;
import enums.DropDownMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithProfileTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    EditDeletePostPage editDeletePostPage;
    ProfilePage profilePage;
    RegistrationPage registrationPage;
    AdminPanel adminPanel;
    Faker faker = new Faker();

    @Test()
    public void userCanRegisterAsAdmin() {
        String email = "tatyanaskv@gmail.com";
        String password = "1234567Start";
        String confirmPassword = "1234567Start";
        String newPassword = "1234567Start";
        String selectAdmin = "admin";

        String editName = "Tetiana";
        String editSurname = "Tetiana";
        String editBirthday = "20.10.1990";
        String editPhone = "+123456789";
        String editGender = "FEMALE";

        registrationPage = new RegistrationPage(app.driver);
        registrationPage.signUpAsAdminForm();
        registrationPage.waitForLoading();
        registrationPage.registrationAsAdmin(email, password, confirmPassword, selectAdmin );

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();

        profilePage = new ProfilePage(app.driver);
        profilePage.openEditProfilePage();
        profilePage.editProfile(editName, editSurname, editBirthday, editPhone, editGender, password, newPassword, newPassword );
        profilePage.goToHomePage();

        homeblogPage.waitForLoading();
        String nameOnHomepage = homeblogPage.getUserNameFromHomePage();
        Assert.assertEquals(nameOnHomepage, editName);

        homeblogPage.hoverOverElement(app.driver);
        homeblogPage.clickOnOneFromDropDownMenu(DropDownMenu.AdminPanel);

        adminPanel = new AdminPanel(app.driver);
        adminPanel.deleteProfile(email);

    }
}
