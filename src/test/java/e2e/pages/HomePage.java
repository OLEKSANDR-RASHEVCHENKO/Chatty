package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='home-blog-component']")
    WebElement postsComponent;
    @FindBy(xpath = "//*[@alt='Logo']")
    WebElement header;
    @FindBy(xpath = "//*[@for='myPostsId']")
    WebElement myPostsCheckBox;
    @FindBy(xpath = "//*[@class='user__img']")
    WebElement userImage;
    @FindBy(xpath = "//*[@class='sidebar__section']//p")
    WebElement nameUnderImage;
    @FindBy(xpath = "//p[contains(text(), 'Hello,')]")
    WebElement helloUser;
    @FindBy(xpath = "//*[@alt='NewsFeed']")
    WebElement newsFeedButton;
    @FindBy(xpath = "//*[@alt='Drafts']")
    WebElement myDraftsButton;
    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement createPostButton;
    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;
    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;
    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement textAreaInput;
    @FindBy(xpath = "//*[@class='post_uploaded_image__7qSWV']")
    WebElement uploadPhoto;
    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement calendar;
    @FindBy(xpath = "//*[@for='draftCheckbox']")
    WebElement savePostAsDraft;
    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//*[@data-test='uploaded-image']")
    WebElement uploadedImages;
    @FindBy(xpath = "//*[@data-test='posts-component']//*[@class='container']")
    WebElement containerInMyPosts;
    @FindBy(xpath = "//*[@class='form-group'][1]//*[@class='error']")
    WebElement titleErrorMassage;
    @FindBy(xpath = "//p[@class='error' and text()='Please fill all fields'][last()]")
    WebElement errorMassage;

    @FindBy(xpath = "//*[@href='/contact']")
    WebElement contactUsButton;

    public void titleError(){
        getWait().forVisibility(titleErrorMassage);
        Assert.assertTrue(titleErrorMassage.isDisplayed());
    }
    public void errorMessage(){
        getWait().forVisibility(errorMassage);
        Assert.assertTrue(errorMassage.isDisplayed());
    }

    @Step("Waite for Post")
    public void waitForPosts(){
        Assert.assertTrue(postsComponent.isDisplayed());
    }


    @Step("Load post:{title},{description},{area}")
    public void loadPost(String title,String description,String area,String filePath,String data){
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        textAreaInput.sendKeys(area);
        uploadPhoto(filePath);
        getWait().forVisibility(uploadedImages);
        Assert.assertTrue(uploadedImages.isDisplayed());
        calendar.sendKeys(data);
        getWait().forVisibility(calendar);
        submitButton.click();
    }
    @Step("Load post as draft:{title},{description},{area}")
    public void loadPostAsDraft(String title,String description,String area,String filePath,String data){
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        textAreaInput.sendKeys(area);
        uploadPhoto(filePath);
        getWait().forVisibility(uploadedImages);
        Assert.assertTrue(uploadedImages.isDisplayed());
        calendar.sendKeys(data);
        getWait().forVisibility(calendar);
        savePostAsDraft.click();
        submitButton.click();
    }

    public void uploadPhoto(String filePath) {
        WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
        fileInput.sendKeys(filePath);
    }
    @Step("Get title from Post")
    public String getTitleFromCreatedPost(String titleName){
        String createdPost = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='"+titleName+"']")).getText();
        return createdPost;
    }
    @Step("Click on created Post")
    public void clickOnCreatedPost(String titleName){
        WebElement createdPost = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='"+titleName+"']"));
        createdPost.click();
    }
    @Step("check if Post was deleted")
    public boolean isPostPresent(String title){
        List<WebElement> posts = driver.findElements(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='"+title+"']"));
        return !posts.isEmpty();
    }
    @Step("Get user name from Home page")
    public String getUserNameFromHomePage(){
        String userNameUnderImage = nameUnderImage.getText();
        return  userNameUnderImage;
    }

    public void waitForVisibility(){
        getWait().forVisibility(header);
        getWait().forVisibility(helloUser);
        getWait().forVisibility(userImage);
        getWait().forVisibility(nameUnderImage);
        getWait().forVisibility(myDraftsButton);
        getWait().forVisibility(createPostButton);
        getWait().forVisibility(newsFeedButton);
        Assert.assertTrue(header.isDisplayed());
        Assert.assertTrue(userImage.isDisplayed());
    }
    public void switchToMyPosts(){
        myPostsCheckBox.click();
        getWait().forVisibility(containerInMyPosts);
    }
    public void switchToMyPostsWithoutPosts(){
        myPostsCheckBox.click();
        getWait().forVisibility(postsComponent);
    }
    public void clickOnNewsFeed(){
        newsFeedButton.click();

    }
    public void clickOnMyDraftsButton(){
        myDraftsButton.click();
    }
    public void clickOnCreatePost(){
        createPostButton.click();
    }

    public void clickContact(){
        contactUsButton.click();
    }
}


