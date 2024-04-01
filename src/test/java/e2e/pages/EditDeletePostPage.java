package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditDeletePostPage extends BasePage{
    public EditDeletePostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//*[@data-test='edit-button']")
    WebElement editButton;

    @FindBy(xpath ="//*[@data-test='delete-button']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement editTitle;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement editDescription;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement editTextarea;

    @FindBy(xpath = "//*[@data-test='uploaded-image']")
    WebElement editImage;

    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement editPublishDate;

    @FindBy(xpath = "//*[@for='draftCheckbox']")
    WebElement editDraft;

    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement editSubmitButton;

    @Step("Wait for loading edit page")
    public void waitForLoading() {
        getWait().forVisibility(editButton);
        getWait().forVisibility(deleteButton);
    }

    public void clickEditButton(){
        editButton.click();
    }

    public void setEditTitle(String title){
        editTitle.sendKeys(title);
    }
    public void setEditDescription(String description){
        editTitle.sendKeys(description);
    }
    public void setEditTextarea(String textarea){
        editTitle.sendKeys(textarea);
    }
    public void getEditImage(String imageInput){
        driver.findElements(By.xpath("//*[@src='https://chatty-images-s3.s3.eu-central-1.amazonaws.com/c5823264-dec3-4cc6-a77f-0bbca9ac7535/d668e640-91ed-4946-9600-4d04da9203d4.jpeg']"));
    }
    public void setEditImageInput(String editImageInput){
        editImage.sendKeys("/Users/Tanya/Desktop/Cat2.jpeg");
    }

    public void clickSaveButton(){
        editSubmitButton.click();
    }
}
