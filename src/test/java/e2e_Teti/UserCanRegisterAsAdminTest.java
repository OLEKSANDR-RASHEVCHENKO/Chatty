package e2e_Teti;

import com.github.javafaker.Faker;
import e2e_Teti.pages.*;
import org.testng.annotations.Test;

public class UserCanRegisterAsAdminTest extends BaseTest {
        LoginPage loginPage;
        HomeblogPage homeblogPage;
        EditDeletePostPage editDeletePostPage;
        ProfilePage profilePage;
        RegistrationPage registrationPage;
        Faker faker = new Faker();

        @Test()
        public void userCanRegisterAsAdmin() {
            String email = "tatyanaskv@gmail.com";
            String password = "1234567Start";
            String confirmPassword = "1234567Start";
            String newPassword = "12345678Start";
            String selectAdmin = "admin";

            registrationPage = new RegistrationPage(app.driver);
            registrationPage.signUpAsAdminForm();
            registrationPage.waitForLoading();
            registrationPage.registrationAsAdmin(email, password, confirmPassword, selectAdmin );
            registrationPage.waitForLoading();

            homeblogPage = new HomeblogPage(app.driver);
            homeblogPage.waitForLoading();

        }
    }

