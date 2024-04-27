package integration.tests.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.authApi.AuthApi;
import integration.schemas.UserUpdateReq;
import integration.uploadPhoto.UploadPhoto;
import integration.user.GetUser;
import integration.user.UpdateUser;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class AdminCanUpdateProfile {
    AuthApi authApi;
    Faker faker = new Faker();
    GetUser getUser;
    UpdateUser updateUser;
    UploadPhoto uploadPhoto;

    @Epic(value = "User can update Profile")
    @Feature(value = "Profile updating")
    @Story(value = "User can update profile with role admin")
    @Description(value = "User can update profile")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "User can update profile")
    public void adminCanRegistrationAsUserWithValidData() throws JsonProcessingException {
        String email = faker.internet().emailAddress();
        String password = "Gazmanov1234";
        String confirmPassword = "Gazmanov1234";
        String role = "admin";
        String newName = faker.name().firstName();
        String newSurname = faker.name().lastName();
        String newBirthDate = "";
        String newPhone = "+" + faker.phoneNumber().subscriberNumber(10);
        String newGender = "MALE";
        String bac = "sssddd";
        File filePathToPhoto = new File("src/test/java/integration/photo/vinni-pukh-v-png.png");
        boolean newBlockedStatus = false;
        authApi = new AuthApi();
        authApi.registration(email, password, confirmPassword, role, 201);

        String token = authApi.login(email, password, 200);

        getUser = new GetUser(token);
        String userJson = getUser.getUser(200);
        JsonPath object = new JsonPath(userJson);
        String userId = object.getString("id");

        uploadPhoto = new UploadPhoto(token);
        String imageId = uploadPhoto.uploadImage(filePathToPhoto, 201);

        UserUpdateReq userUpdateReq = new UserUpdateReq();
        userUpdateReq.setName(newName);
        userUpdateReq.setSurname(newSurname);
        userUpdateReq.setBirthDate(newBirthDate);
        userUpdateReq.setPhone(newPhone);
        userUpdateReq.setGender(newGender);
        userUpdateReq.setAvatarUrl(imageId);
        userUpdateReq.setBlocked(newBlockedStatus);

        updateUser = new UpdateUser(token);
        updateUser.updateUser(imageId, newName, newSurname, newBirthDate, newPhone, newGender, bac, newBlockedStatus, userId, 200);
        String updatedUserJson = getUser.getUser(200);
        JsonPath updatedUser = new JsonPath(updatedUserJson);

        assertEquals(updatedUser.getString("name"), newName);
        assertEquals(updatedUser.getString("surname"), newSurname);
        assertEquals(updatedUser.getString("phone"), newPhone);
        assertEquals(updatedUser.getString("gender"), newGender);
        assertEquals(updatedUser.getString("avatarUrl"), imageId);

    }
}
