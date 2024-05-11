package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPanel extends BasePage {
    public AdminPanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='adminPanelTitle']")
    WebElement header;
    @FindBy(xpath = "//*[@data-test='searchEmailInput']")
    WebElement searchInput;
    @FindBy(xpath = "//*[@data-test='searchEmailButton']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@data-test='editUserButton']")
    WebElement editButton;
    @FindBy(xpath = "//*[@data-test='deleteUserButton']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@data-test='userRow']")
    WebElement informationAboutUsers;

    public void takeHeaderScreenshotOnAdminPanel(String actualScreenshotName) {
        takeAndCompareScreenshot(actualScreenshotName, header);
    }

    @Step("Wait for Loading Admin panel Page")
    public void waitForLoading() {
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }

    @Step("Waite for User")
    public void waitForUser() {
        getWait().forVisibility(informationAboutUsers);
        Assert.assertTrue(informationAboutUsers.isDisplayed());
    }

    @Step("Check that user is not visible")
    public void userIsNotVisible() {
        getWait().forInvisibility(informationAboutUsers);
    }

    @Step("Search user")
    public void searchUser(String userEmail) {
        searchInput.sendKeys(userEmail);
        searchButton.click();
    }

    @Step("Delete user")
    public void deleteUser() {
        deleteButton.click();
    }


}
