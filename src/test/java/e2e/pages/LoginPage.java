package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='form']")
    WebElement loginHeader;
    @FindBy(xpath = "//*[@class='link']//a")
    WebElement registrationLink;
    @FindBy(xpath = "//*[@class='link']")
    WebElement dontHaveAnAccText;
    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement signUpLink;
    @FindBy(xpath = "//*[@data-test='email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@class='password-eye']")
    WebElement passwordEye;
    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='text-error']")
    WebElement errorMessage;
    @Step("Wait for loading login page")
    public void waitForVisibility(){
        getWait().forVisibility(loginHeader);
        getWait().forVisibility(dontHaveAnAccText);
        getWait().forClickable(signUpLink);
        getWait().forVisibility(emailField);
        getWait().forVisibility(passwordField);
        getWait().forClickable(passwordEye);
        getWait().forVisibility(loginButton);
    }
    public void clickToRegistration(){
        registrationLink.click();
    }
    @Step("Wait for loading error massage")
    public void waitForErrorMassage(){
        getWait().forVisibility(errorMessage);
    }
    public void elementIsNotClickable(){
        getWait().forInClickable(loginButton);
    }
    @Step("Login as user:{email},{password}")
    public void loginInSystem(String email,String password){
        emailField.sendKeys(email);
        passwordEye.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void takeLoginPageScreenshot(String actualScreenshotName){
        takeAndCompareScreenshot(actualScreenshotName, null);
    }
}