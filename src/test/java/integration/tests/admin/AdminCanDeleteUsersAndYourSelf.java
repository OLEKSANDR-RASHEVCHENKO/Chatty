package integration.tests.admin;

import com.github.javafaker.Faker;
import integration.authApi.AuthApi;
import integration.user.DeleteUser;
import integration.user.GetUser;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class AdminCanDeleteUsersAndYourSelf {
    AuthApi authApi;
    GetUser getUser;
    DeleteUser deleteUser;

    Faker faker = new Faker();

    @Test

    public void adminCanDeleteUsersAndYourself() {
        String userEmail = faker.internet().emailAddress();
        String userPassword = "Gazmanov1234";
        String confirmUserPassword = "Gazmanov1234";
        String role = "user";

        String adminEmail = faker.internet().emailAddress();
        ;
        String adminPassword = "Gazmanov1234";
        String confirmAdminPassword = "Gazmanov1234";
        String adminRole = "admin";
        authApi = new AuthApi();
        authApi.registration(userEmail, userPassword, confirmUserPassword, role, 201);
        String token = authApi.login(userEmail, userPassword, 200);
        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");


        authApi.registration(adminEmail, adminPassword, confirmAdminPassword, adminRole, 201);
        String adminToken = authApi.login(adminEmail, adminPassword, 200);
        getUser = new GetUser(adminToken);
        String adminJson = getUser.getUser(200);
        JsonPath object1 = new JsonPath(adminJson);
        String adminId = object1.getString("id");

        deleteUser = new DeleteUser(adminToken);
        deleteUser.deleteUser(userId, 204);

        getUser = new GetUser(token);
        getUser.getUser(404);

        deleteUser.deleteUser(adminId, 204);
    }
}
