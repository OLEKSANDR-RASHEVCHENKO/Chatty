package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath ="//*[@class='input-password']")
    WebElement passwordInput;

    @FindBy(xpath ="//*[@name='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[@class='registration-btn']")
    WebElement registrationButton;

    @Step("Wait for loading Login page")
    public void waitForLoading(){
        getWait().forVisibility(emailInput);
        getWait().forVisibility(passwordInput);
        getWait().forVisibility(confirmPassword);
        getWait().forVisibility(registrationButton);
    }
}
