package e2e.test;

import com.github.javafaker.Faker;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.PostPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanCreateEditDeletePostTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    PostPage postPage;
    Faker faker;

    @Feature(value = "User can create post then edit then delete")
    @Story(value = "User can create post and edit then and delete then")
    @Description(value = "Checking on the process of creating deleting adn editing posts")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can create delete and edit post4")
    public void userCanCreateEditDeletePostTest() {
        String email = "chipsa15@gmail.com";
        String password = "Gazmanov1234";
        faker = new Faker();
        String title = faker.name().firstName();
        String description = faker.book().title();
        String textArea = faker.lorem().paragraph();
        String dogPhotoUserCanCreateEditeDeletePost = "C:\\Users\\Oleksandr\\IdeaProjects\\Chatty\\src\\test\\java\\photo\\userCanCreateEditDeletePostTest_Dog.jpg";
        String data = "28.03.2025";
        String editedTitle = faker.name().firstName();
        String editedDescription = faker.book().title();
        String editedTextArea = faker.lorem().paragraph();
        String editedDogUserCanCreateEditDeletePost = "C:\\Users\\Oleksandr\\IdeaProjects\\Chatty\\src\\test\\java\\photo\\userCanCreateEditDeletePostTest_Dog_Litle.jpg";

        loginPage = new LoginPage(app.driver);
        loginPage.loginInSystem(email, password);

        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnCreatePost();
        homePage.loadPostAsDraft(title, description, textArea, dogPhotoUserCanCreateEditeDeletePost, data);
        homePage.waiteForVisibility();
        homePage.switchToMyPosts();
        homePage.scrollToBottom();
        String titleName = homePage.getTitleFromCreatedPost(title);
        Assert.assertEquals(title, titleName);
        homePage.clickOnCreatedPost(title);

        postPage = new PostPage(app.driver);
        postPage.waitForLoading();
        postPage.editePost(editedTitle, editedDescription, editedTextArea, editedDogUserCanCreateEditDeletePost);
        postPage.clickOnHeader();
        homePage.waiteForVisibility();
        homePage.switchToMyPosts();
        String editedTitleName = homePage.getTitleFromCreatedPost(editedTitle);
        Assert.assertEquals(editedTitleName, editedTitle);
        homePage.clickOnCreatedPost(editedTitle);
        postPage.waitForLoading();
        postPage.deletePost();
        homePage.waiteForVisibility();
        homePage.switchToMyPostsWithoutPosts();
        homePage.waiteForPosts();
        Assert.assertFalse(homePage.isPostPresent(editedTitle));
    }
}
