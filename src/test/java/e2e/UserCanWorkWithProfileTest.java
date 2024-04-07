package e2e;

import com.github.javafaker.Faker;
import e2e.pages.EditDeletePostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.testng.annotations.Test;

public class UserCanWorkWithProfileTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    EditDeletePostPage editDeletePostPage;
    ProfilePage profilePage;
    Faker faker = new Faker();


    @Test()
    public void userCanCreatePost() {
        String email = "tatyanaskv@gmail.com";
        String password = "123456Start";
        String newPassword = "1234567Start";

        faker = new Faker();
        String editName = "Tetiana";
        String editSurname = "Tetiana";
        String editBirthday = "20.10.1990";
        String editPhone = "+123456789";
        String editGender = "FEMALE";


        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);


        profilePage = new ProfilePage(app.driver);
        profilePage.openEditProfilePage();
        profilePage.editProfile(editName, editSurname, editBirthday, editPhone, editGender, password, newPassword, newPassword );

    }
}
