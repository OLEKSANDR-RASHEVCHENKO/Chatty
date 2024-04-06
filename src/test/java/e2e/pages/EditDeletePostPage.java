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

    @Step("Edit post")
    public void editPost(String editTitleInput, String editDescriptionInput, String editTextareaInput,String editImagePath){
        editButton.click();
        getWait().forVisibility(editTitle);
        editTitle.clear();
        editTitle.sendKeys(editTitleInput);
        editDescription.clear();
        editDescription.sendKeys(editDescriptionInput);
        editTextarea.clear();
        editTextarea.sendKeys(editTextareaInput);
        downloadImage(editImagePath);
        getWait().forVisibility(editImage);
        editSubmitButton.click();
    }

    @Step("Edit image")
    public void downloadImage(String imagePath) {
        WebElement imageInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
        imageInput.sendKeys(imagePath);
    }
    @Step("Find edited post by title")
    public String getPostEditTitle(String editedTitle){
        String editedPost = driver.findElement(By.xpath("//*[@data-test='post']//*[@class='post-content__top']//h3[text()='" + editedTitle +"']")).getText();
        return editedPost;
    }

    @Step("Delete post")
    public void deletePost(){
        deleteButton.click();
    }








//    driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));public void clickEditButton(){
//        editButton.click();
//    }



//    public void getEditImage(String imageInput){
//        WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
//        fileInput.click();
//    }
//
//    public void setEditImageInput(String newImage){
//        editImage.sendKeys("/Users/Tanya/Desktop/Cat2.jpeg");
//    }

//    public void clickSaveButton(){
//        editSubmitButton.click();
//    }
}
