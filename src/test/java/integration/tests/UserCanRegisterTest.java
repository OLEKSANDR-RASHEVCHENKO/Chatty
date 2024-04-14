package integration.tests;

import com.github.javafaker.Faker;
import integration.authorisation.RegistrationUser;
import org.testng.annotations.Test;

public class UserCanRegisterTest {
    Faker faker = new Faker();
    RegistrationUser registrationUser;


    @Test(description = "User can register")
    public void userCanRegistrationAsUser() {
        String email = faker.internet().emailAddress();
        String password = "qwerty1234";
        String confirmPassword = "qwerty1234";
        String role = "user";
        registrationUser = new RegistrationUser();
        registrationUser.registration(email, password, confirmPassword, role, 201);
    }

    @Test(description = "User can  not register with invalid Email")
    public void userCanRegistrationAsUserWithInvalidEmail() {
        String email = "teddy";
        String password = "qwerty1234";
        String confirmPassword = "qwerty1234";
        String role = "user";
        registrationUser = new RegistrationUser();
        registrationUser.registration(email, password, confirmPassword, role, 400);
    }

    @Test(description = "User can  not register with invalid password")
    public void userCanRegistrationAsUserWithInvalidPassword() {
        String email = "teddy12345@gmail.com";
        String password = "mimi";
        String confirmPassword = "mimi";
        String role = "user";
        registrationUser = new RegistrationUser();
        registrationUser.registration(email, password, confirmPassword, role, 400);
    }


}
