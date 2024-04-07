package e2e;

import com.github.javafaker.Faker;
import e2e.pages.EditDeletePostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithPostTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    EditDeletePostPage editDeletePostPage;
    Faker faker = new Faker();

    @Test()
    public void userCanCreatePost() {
        String email = "tatyanaskv12@rambler.ru";
        String password = "123456Start";

        faker = new Faker();
        String title = faker.name().firstName();
        String description = faker.name().firstName();
        String textarea = faker.lorem().sentence();
        String image = "/Users/Tanya/Desktop/Cat.jpeg";

        String editTitle = faker.name().firstName();
        String editDescription = faker.name().firstName();
        String editTextarea = faker.lorem().sentence();
        String editImage = "/Users/Tanya/Desktop/Cat2.jpeg";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.openCreatePostPage();

        homeblogPage.waitForLoading();
        homeblogPage.setTitleInput(title);
        homeblogPage.setDescriptionInput(description);
        homeblogPage.setTextareaInput(textarea);
        //homeblogPage.getImage(imageInput);
        homeblogPage.downloadPhoto(image);
        homeblogPage.setImageInput(image);
        homeblogPage.waitForLoading();
        homeblogPage.savePost();
        homeblogPage.waitForLoading();
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();
        String createdTitle = homeblogPage.getPostTitle(title);
        Assert.assertEquals(createdTitle, title);
        homeblogPage.clickOnPost(title);

        editDeletePostPage = new EditDeletePostPage(app.driver);
        editDeletePostPage.waitForLoading();
        editDeletePostPage.editPost(editTitle, editDescription, editTextarea, editImage);
        editDeletePostPage.waitForLoading();

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.clickLogo();
        homeblogPage.clickMyPostsButton();
        String editedTitle = editDeletePostPage.getPostEditTitle(editTitle);
        Assert.assertEquals(editedTitle, editTitle);
        homeblogPage.clickOnPost(editedTitle);

        editDeletePostPage = new EditDeletePostPage(app.driver);//
        editDeletePostPage.deletePost();
        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();
        //Assert.assertFalse(homeblogPage.che);

    }




//        homeblogPage.clickMyPostsButton();
//        homeblogPage.waitForLoading();


//        editDeletePostPage = new EditDeletePostPage(app.driver);
//        editDeletePostPage.getPostEditTitle(editedTitle);
//
//        homeblogPage = new HomeblogPage(app.driver);
//        homeblogPage.waitForLoading();




}