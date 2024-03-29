package e2e.pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//*[@class='post_uploaded_image__7qSWV']")
    WebElement imageInput;

    @FindBy(xpath = "//*[@id='publishDate']")
    WebElement publishDateButton;

    @FindBy(xpath = "//*[@data-test='checkbox']")
    WebElement draftButton;

    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement submitButton;

    @Step("Create post as a user")
    public void waitForOpen() {
        getWait().forVisibility(titleInput);
        getWait().forVisibility(descriptionInput);
        getWait().forVisibility(textareaInput);
        getWait().forVisibility(imageInput);
        getWait().forClickable(publishDateButton);
        getWait().forClickable(draftButton);
        getWait().forClickable(submitButton);
    }

    public void setTitleInput() {
        setTitleInput();


    }
}
