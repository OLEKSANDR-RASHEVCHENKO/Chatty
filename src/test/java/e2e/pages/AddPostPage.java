package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPostPage extends HomeblogPage{
    public AddPostPage(WebDriver driver) {
        super(driver);
    }

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

    @Step("Create post as a user")
    public void waitForLoading() {
        getWait().forVisibility(titleInput);
        getWait().forVisibility(descriptionInput);
        getWait().forVisibility(textareaInput);
        //getWait().forClickable(imageInput);
        getWait().forVisibility(publishDateButton);
        getWait().forVisibility(draftButton);
        getWait().forClickable(submitButton);
    }

    public void setTitleInput(String title) {
        titleInput.sendKeys(title);
    }

    public void setDescriptionInput(String description) {
        descriptionInput.sendKeys(description);
    }

    public void setTextareaInput(String textarea) {
        textareaInput.sendKeys(textarea);
    }

//    public void getTitle(String title){
//        driver
//    }

    public void getImage(String imageInput){
       driver.findElements(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
    }
    public void setImageInput(String image){
        imageInput.sendKeys("/Users/Tanya/Desktop/Cat.jpeg");
    }

    @Step("Save post as a draft")
    public void savePostAsDraft(){
        draftButton.click();
    }

    public void savePost(){
        submitButton.click();
    }





}
