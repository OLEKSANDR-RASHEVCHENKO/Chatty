package integration.tests.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.user.GetAllUsersAsAdmin;
import org.testng.annotations.Test;

public class UserCanNotGetAllUsers {
    AuthApi authApi;
    GetAllUsersAsAdmin getAllUsersAsAdmin;

    @Test
    public void userCanNotGetAllUsers() throws JsonProcessingException {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov1234";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);
        getAllUsersAsAdmin = new GetAllUsersAsAdmin(token);
        getAllUsersAsAdmin.getAllUsersAsAdmin(403, 0, 10);
    }
}