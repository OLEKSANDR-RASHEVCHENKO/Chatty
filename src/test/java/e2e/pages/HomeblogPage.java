package e2e.pages;

import io.qameta.allure.Step;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class HomeblogPage extends BasePage {
    public HomeblogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@alt='Logo']")
    public WebElement logo;

    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement plusButton;

    @FindBy(xpath = "//*[@for='myPostsId']")
    WebElement myPostsButton;

    @FindBy(xpath = "//*[@alt='Drafts']")
    WebElement myDraftsButton;

    @FindBy(xpath = "//*[@class='post-content__top']")
    WebElement postTitle;

    @FindBy(xpath = "//*[@class='post__description']")
    WebElement postDescription;

    @FindBy(xpath = "//*[@data-test='post']")
    WebElement post;

    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement textareaInput;

    @FindBy(xpath = "//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']")
    WebElement imageInput;

    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement publishDateButton;

    @FindBy(xpath = "//*[@for='draftCheckbox']")
    WebElement draftButton;

    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement submitButton;

    @Step("Wait for loading homeblog page")
    public void waitForLoading() {
        getWait().forVisibility(logo);
        //getWait().forVisibility(myDraftsButton);
        //getWait().forVisibility(myPostsButton);
        //getWait().forVisibility(titleInput);
        //getWait().forVisibility(descriptionInput);
        //getWait().forVisibility(textareaInput);
        //getWait().forClickable(imageInput);
        //getWait().forVisibility(publishDateButton);
        //getWait().forVisibility(draftButton);
        //getWait().forClickable(submitButton);
    }
    public void createPost(String title, String description, String textarea,String image){

        getWait().forVisibility(postTitle);
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        textareaInput.sendKeys(textarea);
        downloadPhoto(image);
        getWait().forVisibility(imageInput);
        submitButton.click();


    }

    @Step("Open create post page")
    public void openCreatePostPage() {
        getWait().forVisibility(plusButton);
        getWait().forClickable(plusButton);
        plusButton.click();
    }
    @Step("Open my drafts")
    public void openMyDrafts(){
        myDraftsButton.click();
    }

    public void clickMyPostsButton(){
        myPostsButton.click();
    }

//    public void clickOnPost(){
//        post.click();
//    }

    public String getPostTitle(String title){
        String createdPost = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='" + title +"']")).getText();
        return createdPost;
    }

    public void clickLogo(){
        logo.click();
    }
    public void clickOnPost(String title){
        WebElement createdPost = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='" + title +"']"));
        createdPost.click();
    }

    public void setTitleInput(String title) {
        titleInput.sendKeys(title);
    }

    public void setDescriptionInput(String description) {
        descriptionInput.sendKeys(description);
    }

    public void setTextareaInput(String textarea) {
        //textareaInput.sendKeys(textarea);
    }

//    public String getTitle() {
//        return titleInput.getText();
//    }
//    public String getDescription() {
//        return descriptionInput.getText();
//    }

    public void getImage(String imageInput){
        driver.findElements(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
    }
    public void setImageInput(String image){
        imageInput.sendKeys("/Users/Tanya/Desktop/Cat2.jpeg");
    }

//    @Step("Save post as a draft")
//    public void savePostAsDraft(){
//        draftButton.click();
//    }

    public void savePost(){
        submitButton.click();
    }


//    public boolean checkIfPostDeleted(String title){
//        List<WebElement> post = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='" + title +"']"));
//        return !post.isEmpty();
//    }
public void downloadPhoto(String imagePath) {
    WebElement imageInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
    imageInput.sendKeys(imagePath);
}
}

