package integration.users;

import com.github.javafaker.Faker;
import integration.authorisation.LoginUser;
import integration.authorisation.RegistrationUser;
import integration.userController.DeleteUser;
import integration.userController.GetUser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCanDeleteUsersAndYourself {
    RegistrationUser registrationUser;
    GetUser getUser;
    DeleteUser deleteUser;
    LoginUser loginUser;

    Faker faker = new Faker();

    @Test

    public void adminCanDeleteUsersAndYourself() {
        String userEmail = faker.internet().emailAddress();
        String userPassword = "qwerty123";
        String confirmUserPassword = "qwerty123";
        String role = "user";

        String adminEmail = faker.internet().emailAddress();
        String adminPassword = "qwerty123";
        String confirmAdminPassword = "qwerty123";
        String adminRole = "admin";
        registrationUser = new RegistrationUser();
        registrationUser.registration(userEmail, userPassword, confirmUserPassword, role, 201);
        String token = loginUser.login(userEmail, userPassword, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");


        registrationUser.registration(adminEmail, adminPassword, confirmAdminPassword, adminRole, 201);
        String adminToken = loginUser.login(adminEmail, adminPassword, 200);
        getUser = new GetUser(adminToken);
        String adminJson = getUser.getUser(200);
        JsonPath object1 = new JsonPath(adminJson);
        String adminId = object1.getString("id");

        deleteUser = new DeleteUser(adminToken);
        deleteUser.deleteUser(userId, 204);

        try {
            getUser = new GetUser(token);
            String userJson1 = getUser.getUser(404);
            JsonPath object2 = new JsonPath(userJson1);
            String userId1 = object2.getString("id");
            Assert.fail("User should not be found after deletion, but user data was retrieved.");
        } catch (AssertionError e) {
            if (e.getMessage().contains("Expected status code <200> but was <404>")) {
                System.out.println("User not found as expected after deletion.");
            } else {
                throw e;
            }
        }
        deleteUser.deleteUser(adminId, 204);
    }
}
