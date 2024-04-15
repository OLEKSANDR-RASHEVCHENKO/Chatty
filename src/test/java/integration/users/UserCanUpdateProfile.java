package integration.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import integration.authorisation.LoginUser;
import integration.schemas.UserUpdateReq;
import integration.uploadPhoto.UploadPhoto;
import integration.userController.GetUser;
import integration.userController.UpdateUser;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class UserCanUpdateProfile {


    LoginUser loginUser;
    GetUser getUser;
    UpdateUser updateUser;
    UploadPhoto uploadPhoto;
    Faker faker = new Faker();

    @Epic(value = "User can update Profile")
    @Feature(value = "Profile updating")
    @Story(value = "User can update profile with role user")
    @Description(value = "User can update profile")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "User can update profile")
    public void userCanUpdateProfile() throws JsonProcessingException {
        String email = "rashevc88495f@gmail.com";
        String password = "Gazmanov1234";
        String newName = faker.name().firstName();
        String newSurname = faker.name().lastName();
        String newBirthDate = "";
        String newPhone = "+" + faker.phoneNumber().subscriberNumber(10);
        String newGender = "MALE";
        File filePathToPhoto = new File("src/test/java/Integration/Photo/Man-PNG-Photo.png");
        boolean newBlockedStatus = false;

        loginUser = new LoginUser();
        String token = loginUser.login(email, password, 200);

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
        updateUser.updateUser(userId, userUpdateReq, 200);
        String updatedUserJson = getUser.getUser(200);
        JsonPath updatedUser = new JsonPath(updatedUserJson);

        assertEquals(updatedUser.getString("name"), newName);
        assertEquals(updatedUser.getString("surname"), newSurname);
        assertEquals(updatedUser.getString("phone"), newPhone);
        assertEquals(updatedUser.getString("gender"), newGender);
        assertEquals(updatedUser.getString("avatarUrl"), imageId);

    }
}
