package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath ="//*[@class='input-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@class='registration-btn']")
    WebElement loginButton;

    @Step("Wait for loading Login page")
    public void waitForLoading(){
        getWait().forVisibility(emailInput);
        getWait().forVisibility(passwordInput);
        getWait().forVisibility(loginButton);
}
public void takeLoginPageScreenShot(String actualScreenShotName){
        takeAndCompareScreenshot(actualScreenShotName, null );
}

@Step("Login as a user: {email}, {password}")
    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
}

}
