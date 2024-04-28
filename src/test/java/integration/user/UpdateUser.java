package integration.user;


import com.fasterxml.jackson.core.JsonProcessingException;
import integration.ApiBase;
import integration.schemas.UserUpdateReq;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertNotNull;

public class UpdateUser extends ApiBase {
    public UpdateUser(String token) {
        super(token);
    }

    @Step("Update user with ID {0}")
    public String updateUser(String avatar, String name, String surname, String birth, String phone, String gender, String back, boolean blocked, String userId, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/users/" + userId;
        Object body = userUpdateReq(avatar, name, surname, birth, phone, gender, back, blocked);

        Response response = putRequest(endpoint, expectedStatusCode, body);


        if (response.getStatusCode() == 200) {
            JsonPath jsonPath = response.jsonPath();
            assertNotNull("ID is missing", jsonPath.get("id"));
            assertNotNull("Name is missing", jsonPath.get("name"));
            assertNotNull("Surname is missing", jsonPath.get("surname"));
            assertNotNull("Phone is missing", jsonPath.get("phone"));
            assertNotNull("Email is missing", jsonPath.get("email"));
            assertNotNull("Gender is missing", jsonPath.get("gender"));
            assertNotNull("AvatarUrl is missing", jsonPath.get("avatarUrl"));
        }
        switch (response.getStatusCode()) {
            case 200:
                return response.asString();
            case 400:
                return "Bad Request: " + response.jsonPath().getString("message");
            case 401:
                return "Unauthorized: " + response.jsonPath().getString("message");
            default:
                return "Unexpected status code: " + response.getStatusCode() + ". Message: " + response.asString();
        }
    }

    public UserUpdateReq userUpdateReq(String avatar, String name, String surname, String birth, String phone, String gender, String back, boolean blocked) {
        UserUpdateReq userUpdateReq = new UserUpdateReq();
        userUpdateReq.setAvatarUrl(avatar);
        userUpdateReq.setName(name);
        userUpdateReq.setSurname(surname);
        userUpdateReq.setBirthDate(birth);
        userUpdateReq.setPhone(phone);
        userUpdateReq.setGender(gender);
        userUpdateReq.setBackgroundUrl(back);
        userUpdateReq.setBlocked(blocked);
        return userUpdateReq;
    }
}
