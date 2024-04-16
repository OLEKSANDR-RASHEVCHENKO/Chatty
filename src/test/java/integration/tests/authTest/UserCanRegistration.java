package integration.tests.authTest;

import com.github.javafaker.Faker;
import integration.authApi.AuthApi;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanRegistration {
    AuthApi authApi;
    Faker faker = new Faker();

    @Epic(value = "Registration")
    @Feature(value = "User registration")
    @Story(value = "User can registration with role user")
    @Description(value = "User can registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can registration")
    public void userCanRegistrationAsUser() {
        String email = faker.internet().emailAddress();
        String password = "123qwert";
        String confirmPassword = "123qwert";
        String role = "user";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 201);
    }

    @Epic(value = "Registration")
    @Feature(value = "User can't registration")
    @Story(value = "User can't registration with role user")
    @Description(value = "user can't Registration As User With Invalid Email")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userCanNotRegistrationWithInvalidEmail() {
        String email = "rashevc88495f";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "user";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 400);
    }

    @Epic(value = "Registration")
    @Feature(value = "User registration")
    @Story(value = "User can't registration with role user")
    @Description(value = "user Can't Registration As User with Invalid Password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userCanNotRegistrationWithInvalidPassword() {
        String email = "rashevc8ddd8495f@gmail.com";
        String password = "Ga";
        String confirmPassword = "Ga";
        String role = "user";
        authApi = new AuthApi();
        String response = authApi.registration(email, password, confirmPassword, role, 400);
    }

    @Epic(value = "Registration")
    @Feature(value = "Admin registration")
    @Story(value = "Admin can registration with role admin")
    @Description(value = "admin can Registration with Valid Data")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void adminCanRegistrationWithValidData() {
        String email = faker.internet().emailAddress();
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "admin";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 201);
    }

    @Epic(value = "Registration")
    @Feature(value = "Admin registration")
    @Story(value = "Admin can registration with role admin")
    @Description(value = "admin can't Registration With Invalid Email")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void adminCanNotRegistrationWithInvalidEmail() {
        String email = "flex@";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "admin";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 400);
    }

    @Epic(value = "Registration")
    @Feature(value = "Admin registration")
    @Story(value = "Admin can't registration with role admin")
    @Description(value = "admin can't Registration With Invalid Password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void adminCanNotRegistrationAsUserWithInvalidPassword() {
        String email = "flex@gmail.com";
        String password = "Ga";
        String confirmPassword = "Ga";
        String role = "admin";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 400);
    }
}