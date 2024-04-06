package e2e;

import com.github.javafaker.Faker;
import e2e.pages.AddPostPage;
import e2e.pages.EditDeletePostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanCreatePostTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    //AddPostPage addPostPage;
    EditDeletePostPage editDeletePostPage;


    Faker faker = new Faker();

    public void checkIfPostCreated(String title, String description1){
        String actualTitle = homeblogPage.getTitle();
        String actualDescription = homeblogPage.getDescription();
        Assert.assertEquals(actualTitle, title, actualTitle+ " is not equal " + title);
        Assert.assertEquals(actualDescription, description1, actualDescription+ " is not equal " + description1);
    }


    @Test()
public void userCanCreatePost() throws InterruptedException{
        String email = "tatyanaskv12@rambler.ru";
        String password = "123456Start";

        faker = new Faker();
        String title = faker.name().firstName();
        String description = faker.name().firstName();
        String textarea = faker.lorem().sentence();
        String image = "/Users/Tanya/Desktop/Cat.jpeg";
        String imageInput = "Place to download";

        String editTitle = faker.name().firstName();
        String editDescription = faker.name().firstName();
        String editTextarea = faker.lorem().sentence();
        String editImage = "/Users/Tanya/Desktop/Cat2.jpeg";
        String editImageInput = "Place to download";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.openCreatePostPage();

        //addPostPage = new AddPostPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.setTitleInput(title);
        homeblogPage.setDescriptionInput(description);
        homeblogPage.setTextareaInput(textarea);


        homeblogPage.getImage(imageInput);
        homeblogPage.setImageInput(image);
        homeblogPage.waitForLoading();
        homeblogPage.savePost();

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();
        String createdTitle = homeblogPage.getPostTitle(title);
        Assert.assertEquals(createdTitle, title);
        homeblogPage.clickOnPost(title);

        editDeletePostPage = new EditDeletePostPage(app.driver);
        editDeletePostPage.waitForLoading();
        //editDeletePostPage.clickEditButton();
        editDeletePostPage.editPost(editTitle,editDescription,editTextarea, editImage);
        //editDeletePostPage.getEditImage(editImage);
        //editDeletePostPage.setEditImageInput(editImageInput);
        //editDeletePostPage.clickEditButton();

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.clickLogo();
        homeblogPage.clickMyPostsButton();
        String editedTitle = editDeletePostPage.getPostEditTitle(editTitle);
        Assert.assertEquals(editedTitle, editTitle);
        homeblogPage.clickMyPostsButton();
        homeblogPage.clickOnPost(editedTitle);
        homeblogPage.waitForLoading();

        //editDeletePostPage = new EditDeletePostPage(app.driver);
        editDeletePostPage.deletePost();
        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();








    }



}
