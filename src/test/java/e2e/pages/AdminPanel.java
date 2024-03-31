package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPanel extends BasePage{
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

    public void waitForLoading(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }
    public void waitForUser(){
        getWait().forVisibility(informationAboutUsers);
        Assert.assertTrue(informationAboutUsers.isDisplayed());
    }
    public void userIsNotVisible(){
        getWait().forInvisibility(informationAboutUsers);
    }
    public void searchUser(String userEmail){
        searchInput.sendKeys(userEmail);
        searchButton.click();
    }
    public void deleteUser(){
        deleteButton.click();
    }



}
