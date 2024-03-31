package e2e.test;

import com.github.javafaker.Faker;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.PostPage;
import e2e.test.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanCreateEditDeletePostTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    PostPage postPage;
    Faker faker;

    @Epic(value = "Login")
    @Feature(value= "User login")
    @Story(value = "User can login with role admin")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User Can Login")
    public void user() throws InterruptedException {
        String email = "chipsa15@gmail.com";
        String password = "Gazmanov1234";
        faker = new Faker();
        String title = faker.name().firstName();
        String description = faker.book().title();
        String textArea = faker.lorem().paragraph();
        String filePath = "C:\\Users\\Oleksandr\\OneDrive\\Рабочий стол\\447238255 (1).jpg";
        String data = "28.03.2025";
        String editedTitle = faker.name().firstName();
        String editedDescription = faker.book().title();
        String editedTextArea = faker.lorem().paragraph();
        String editedFilePath = "C:\\Users\\Oleksandr\\OneDrive\\Рабочий стол\\1583662555_17.jpg";
        loginPage = new LoginPage(app.driver);
        loginPage.loginInSystem(email, password);
        homePage = new HomePage(app.driver);
        homePage.waiteForVisibility();
        homePage.hoverOverElement(app.driver);
        homePage.clickOnCreatePost();
        homePage.loadPostAsDraft(title, description, textArea, filePath, data);
        homePage.waiteForVisibility();
        homePage.switchToMyPosts();
        homePage.scrollToBottom();
        String titleName = homePage.getTitleFromCreatedPost(title);
        Assert.assertEquals(title, titleName);
        homePage.clickOnCreatedPost(title);
        postPage = new PostPage(app.driver);
        postPage.waitForLoading();
        postPage.editePost(editedTitle, editedDescription, editedTextArea, editedFilePath);
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
