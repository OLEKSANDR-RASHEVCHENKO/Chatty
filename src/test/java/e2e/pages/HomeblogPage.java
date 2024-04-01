package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @Step("Wait for loading homeblog page")
    public void waitForLoading() {
        getWait().forVisibility(logo);
        getWait().forVisibility(myDraftsButton);
        //getWait().forVisibility(myPostsButton);
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

//    public String getPostTitle() {
//    return postTitle.getText();
//    }
//    public String getPostDescription() {
//        return postDescription.getText();
//    }
    public void clickMyPostsButton(){
        myPostsButton.click();
    }

    public void clickOnPost(){
        post.click();
    }
}

