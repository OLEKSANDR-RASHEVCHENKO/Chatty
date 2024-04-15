package integration.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authorisation.LoginUser;
import integration.userController.GetAllUsersAsAdmin;
import org.testng.annotations.Test;

public class UserCanNotGetAllUsers {
    LoginUser loginUser;
    GetAllUsersAsAdmin getAllUsersAsAdmin;

    @Test
    public void userCanNotGetAllUsers() throws JsonProcessingException {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov1234";
        loginUser = new LoginUser();
        String token = loginUser.login(email, password, 200);
        getAllUsersAsAdmin = new GetAllUsersAsAdmin(token);
        getAllUsersAsAdmin.getAllUsersAsAdmin(200, 0, 10);
    }
}
