package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href='/contact']")
    WebElement contactUsButton;
    @FindBy(xpath = "//*[@id='name']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='content']")
    WebElement messageInput;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendMessageButton;

    public void waitForOpen(){
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

}
