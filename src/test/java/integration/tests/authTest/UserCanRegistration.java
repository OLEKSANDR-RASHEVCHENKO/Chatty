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
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "user";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 201);
    }

    @Test
    public void userCanNotRegistrationAsUserWithInvalidEmail() {
        String email = "rashevc88495f";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "user";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 400);
    }

    @Test
    public void userCanNotRegistrationAsUserWithInvalidPassword() {
        String email = "rashevc8ddd8495f@gmail.com";
        String password = "Ga";
        String confirmPassword = "Ga";
        String role = "user";
        authApi = new AuthApi();
        String response = authApi.registration(email, password, confirmPassword, role, 400);
    }

    @Epic(value = "Registration")
    @Feature(value = "User registration")
    @Story(value = "User can registration with role admin")
    @Description(value = "User can registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can registration")
    public void adminCanRegistrationAsUserWithValidData() {
        String email = faker.internet().emailAddress();
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "admin";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 201);
    }

    @Test
    public void adminCanNotRegistrationAsUserWithInvalidEmail() {
        String email = "flex@";
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "admin";
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 400);
    }

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