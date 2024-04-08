package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='contact-box']//h1")
    WebElement header;
    @FindBy(xpath = "//*[@href='/contact']")
    WebElement contactUsButton;
    @FindBy(xpath = "//*[@id='name']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='content']")
    WebElement messageInput;
    @FindBy(xpath = "//*[@class='error']")
    WebElement invalidEmail;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendMessageButton;
    @FindBy(xpath = "//*[@class='success-message']")
    WebElement successfullyMessage;

    public void waitForLoading(){
        getWait().forVisibility(header);
        getWait().forVisibility(nameInput);
        getWait().forVisibility(emailInput);
        getWait().forVisibility(messageInput);
        getWait().forVisibility(sendMessageButton);}


    public void sendFeedback(String name, String email,String message){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
        sendMessageButton.click();
    }
    public void waitForInvalidMessage(){
        getWait().forVisibility(invalidEmail);
        Assert.assertTrue(invalidEmail.isDisplayed());
    }
    public void waitForSuccessfullyMessage(){
        getWait().forVisibility(successfullyMessage);
        Assert.assertTrue(successfullyMessage.isDisplayed());
    }

}
