package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PostPage extends BasePage{
    public PostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@alt='Logo']")
    WebElement header;
    @FindBy(xpath = "//*[@data-test='post']")
    WebElement post;
    @FindBy(xpath = "//*[@data-test='edit-button']")
    WebElement editButton;
    @FindBy(xpath = "//*[@data-test='delete-button']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@data-test='post-creation-form']")
    WebElement postDescription;
    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;
    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;
    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement textAreaInput;
    @FindBy(xpath = "//*[@data-test='uploaded-image']")
    WebElement uploadedImages;
    @FindBy(xpath = "//*[@for='draftCheckbox']")
    WebElement savePostAsDraft;
    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement calendar;
    public void waitForLoading(){
        getWait().forVisibility(post);
        getWait().forVisibility(editButton);
        getWait().forVisibility(deleteButton);
        Assert.assertTrue(post.isDisplayed());
        Assert.assertTrue(editButton.isDisplayed());
        Assert.assertTrue(deleteButton.isDisplayed());
    }


    public void editePost(String title,String description,String textArea,String path){
        editButton.click();
        getWait().forVisibility(postDescription);
        titleInput.clear();
        titleInput.sendKeys(title);
        descriptionInput.sendKeys(description);
        textAreaInput.sendKeys(textArea);
        uploadPhoto(path);
        getWait().forVisibility(uploadedImages);
        Assert.assertTrue(uploadedImages.isDisplayed());
        submitButton.click();
    }

    public void deletePost(){
        deleteButton.click();
    }



    public void uploadPhoto(String filePath) {
        WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
        fileInput.sendKeys(filePath);
    }

    public void clickOnHeader(){
        header.click();
    }
}
