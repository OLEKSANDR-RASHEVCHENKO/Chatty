package integration.tests.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.user.GetAllUsersAsAdmin;
import org.testng.annotations.Test;

public class AdminCanGetAllUsers {
    AuthApi authApi;
    GetAllUsersAsAdmin getAllUsersAsAdmin;

    @Test
    public void adminCanGetAllUsers() throws JsonProcessingException {
        String email = "alewwx@gmail.com";
        String password = "Gazmanov1234";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);
        getAllUsersAsAdmin = new GetAllUsersAsAdmin(token);
        getAllUsersAsAdmin.getAllUsersAsAdmin(200, 0, 10);
    }
}
