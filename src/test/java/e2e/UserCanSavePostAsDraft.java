package e2e;

import e2e.pages.AddPostPage;
import e2e.pages.EditDeletePostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class UserCanSavePostAsDraft extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    AddPostPage addPostPage;
    EditDeletePostPage editDeletePostPage;


    Faker faker = new Faker();

    @Test()
    public void userCanCreatePost() {
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        String title = faker.name().firstName();
        String description = faker.internet().uuid();
        String textarea = faker.lorem().sentence();
        String image = "Image Path";
        String imageInput = "Download Image";

        String editTitle = "Cat";
        String editDescription = "This is my Cat";
        String editTextarea = "It is very cute";
        String editImage = "Cat2";
        String editImageInput = "New cat";

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

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.openMyDrafts();
        homeblogPage.waitForLoading();
        homeblogPage.clickLogo();


        homeblogPage.waitForLoading();
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();
        homeblogPage.clickOnPost();

        editDeletePostPage = new EditDeletePostPage(app.driver);
        editDeletePostPage.waitForLoading();
        editDeletePostPage.clickEditButton();
        editDeletePostPage.editPost(editTitle,editDescription,editTextarea);

        editDeletePostPage.getEditImage(editImageInput);
        editDeletePostPage.setEditImageInput(editImage);

        editDeletePostPage.clickSaveButton();

//
//
//
//        editDeletePostPage.clickEditButton();
    }
}