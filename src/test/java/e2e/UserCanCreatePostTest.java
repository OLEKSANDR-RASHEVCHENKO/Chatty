package e2e;

import com.github.javafaker.Faker;
import e2e.pages.AddPostPage;
import e2e.pages.HomeblogPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class UserCanCreatePostTest extends BaseTest {
    LoginPage loginPage;
    HomeblogPage homeblogPage;
    AddPostPage addPostPage;


    Faker faker = new Faker();


    @Test()
public void userCanCreatePost() {
        String email = "tatyanaskv@rambler.ru";
        String password = "123456Start";

        String titleInput = faker.internet().uuid();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeblogPage = new HomeblogPage(app.driver);
        homeblogPage.waitForLoading();
        homeblogPage.openCreatePostPage();

        addPostPage.waitForOpen();
    }



}
