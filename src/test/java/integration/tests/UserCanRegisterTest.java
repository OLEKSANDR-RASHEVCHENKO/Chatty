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
        String password = "qwerty123";
        String confirmPassword = "qwerty123";
        String role = "user";
        registrationUser = new RegistrationUser();


    }
}
