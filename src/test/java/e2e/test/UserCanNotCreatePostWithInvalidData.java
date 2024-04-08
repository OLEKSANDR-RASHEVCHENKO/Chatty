package e2e.test;

import com.github.javafaker.Faker;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.PostPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanNotCreatePostWithInvalidData extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    PostPage postPage;
    Faker faker;
    @Epic(value = "Create Post")
    @Feature(value= "User can not create post")
    @Story(value = "User can not create Post")
    @Description(value = "User can not create post")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "User can  not create post")
public void createPostMethod(String title,String description,String textArea,boolean emptyTitle,boolean emptyDesc,boolean emptyTextArea){
    String email = "chipsa15@gmail.com";
    String password = "Gazmanov1234";
    faker = new Faker();
    String filePath = "photo/333.png";
    String data = "28.03.2025";

    loginPage = new LoginPage(app.driver);
    loginPage.loginInSystem(email, password);

    homePage = new HomePage(app.driver);
    homePage.waiteForVisibility();
    homePage.hoverOverElement(app.driver);
    homePage.clickOnCreatePost();
    homePage.loadPost(title,description,textArea,filePath,data);
    if (emptyTitle) {
        homePage.titleError();
    }
    if (emptyDesc) {
        homePage.errorMassage();
    }
    if (emptyTextArea) {
        homePage.errorMassage();
    }
    else {
        homePage.titleError();
        homePage.errorMassage();
    }
}
@Test
public void userCanNotCreatePostWithEmptyTitle(){
    createPostMethod("","dfdf","dfdf",true,false,false);
}
    @Test
    public void userCanNotCreatePostWithEmptyTextArea(){
        createPostMethod("Hallo","dfdf","",false,false,true);
    }
    @Test
    public void userCanNotCreatePostWithEmptyFields(){
        createPostMethod("","","",true,true,true);
    }

}
