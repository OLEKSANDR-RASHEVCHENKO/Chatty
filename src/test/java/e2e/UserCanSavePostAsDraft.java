package e2e;

import e2e.pages.AddPostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class UserCanSavePostAsDraft extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    AddPostPage addPostPage;


    Faker faker = new Faker();

    @Test()
    public void userCanCreatePost() {
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        String title = faker.internet().uuid();
        String description = faker.internet().uuid();
        String textarea = faker.lorem().sentence();
        String image = "Image Path";
        String imageInput = "Place to download";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.openCreatePostPage();

        addPostPage = new AddPostPage(app.driver);
        addPostPage.waitForLoading();
        addPostPage.setTitleInput(title);
        addPostPage.setDescriptionInput(description);
        addPostPage.setTextareaInput(textarea);

        addPostPage.getImage(imageInput);

        addPostPage.setImageInput(image);
        addPostPage.waitForLoading();
        addPostPage.savePostAsDraft();
        addPostPage.savePost();

        homeblogPage.openMyDrafts();
        homeblogPage.waitForLoading();
    }
}