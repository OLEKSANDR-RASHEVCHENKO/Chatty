package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='contact-box']//h1")
    WebElement header;
    @FindBy(xpath = "//*[@id='name']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='content']")
    WebElement contentInput;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendButton;
    @FindBy(xpath = "//*[@class='error']")
    WebElement invalidEmail;
    @FindBy(xpath = "//*[@class='success-message']")
    WebElement successfullyMassage;
    @Step("Waite for loading Contact page")
    public void waiteForLoading(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }
    @Step("Send Massage:{name},{email},{content}")
    public void sendMessage(String name,String email,String content){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        contentInput.sendKeys(content);
        sendButton.click();
    }
    public void takeLoginPageScreenshot(String actualScreenshotName){
        takeAndCompareScreenshot(actualScreenshotName, null);
    }
    @Step("Waite for invalid Massage")
    public void waiteForInvalidMassage(){
        getWait().forVisibility(invalidEmail);
        Assert.assertTrue(invalidEmail.isDisplayed());
    }
    @Step("Wait for successfully Message")
    public void waiteForSuccessfullyMassage(){
        getWait().forVisibility(successfullyMassage);
        Assert.assertTrue(successfullyMassage.isDisplayed());
    }
}