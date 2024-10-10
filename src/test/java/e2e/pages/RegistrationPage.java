package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='form']//h1")
    WebElement header;
    @FindBy(xpath = "//*[@data-test='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@data-test='confirmPassword']")
    WebElement confirmPasswordInput;
    @FindBy(xpath = "//*[@data-test='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//*[@value='user']")
    WebElement user;
    @FindBy(xpath = "//*[@value='admin']")
    WebElement admin;
    @Step("Wait for loading registration Page")
    public void waiteForLoading(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }
    @Step("Registration as user :{email},{password},{confirmPassword}")
    public void registrationAsUser(String email,String password,String confirmPassword){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        user.click();
        submitButton.click();
    }
    @Step("Registration as admin :{email},{password},{confirmPassword}")
    public void registrationAsAdmin(String email,String password,String confirmPassword){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        admin.click();
        submitButton.click();
    }
}