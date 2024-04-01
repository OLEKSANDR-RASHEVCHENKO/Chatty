package e2e;

import com.github.javafaker.Faker;
import e2e.pages.AddPostPage;
import e2e.pages.EditDeletePostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanEditPostTest extends BaseTest{

    LoginPage loginPage;
    HomeblogPage homeblogPage;
    AddPostPage addPostPage;
    EditDeletePostPage editDeletePostPage;


    Faker faker = new Faker();

    public void checkIfPostCreated(String title, String description1){
        String actualTitle = addPostPage.getTitle();
        String actualDescription = addPostPage.getDescription();
        Assert.assertEquals(actualTitle, title, actualTitle+ " is not equal " + title);
        Assert.assertEquals(actualDescription, description1, actualDescription+ " is not equal " + description1);
    }


    @Test()
    public void userCanCreatePost() {
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        String title = faker.internet().uuid();
        String description = faker.internet().uuid();
        String textarea = faker.lorem().sentence();
        String image = "Image Path";
        String imageInput = "Place to download";

        String editTitle = "Cat";
        String editDescription = "This is my Cat";
        String editTextarea = "It is very cute";
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
        addPostPage.savePost();

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        //checkIfPostCreated(title, description);
        homeblogPage.clickMyPostsButton();
        homeblogPage.waitForLoading();
        homeblogPage.clickOnPost();

        editDeletePostPage = new EditDeletePostPage(app.driver);
        editDeletePostPage.waitForLoading();
        editDeletePostPage.clickEditButton();
        editDeletePostPage.setEditTitle(editTitle);
        editDeletePostPage.setEditDescription(editDescription);
        editDeletePostPage.setEditTextarea(editTextarea);
        editDeletePostPage.getEditImage(imageInput);
        editDeletePostPage.setEditImageInput(editImageInput);
        editDeletePostPage.clickEditButton();







    }

}
