package e2e_Teti.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@href='/registration']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath ="//*[@class='input-password']")
    WebElement passwordInput;

    @FindBy(xpath ="//*[@name='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[@class='registration-btn']")
    WebElement registrationButton;

    public void signUpAsAdminForm(){
        signInButton.click();

    }

    @Step("Wait for loading Login page")
    public void waitForLoading(){
        getWait().forVisibility(emailInput);
        getWait().forVisibility(passwordInput);
        //getWait().forVisibility(confirmPassword);
        getWait().forVisibility(registrationButton);
    }



    public void registrationAsAdmin(String emailInput, String passwordInput, String confirmPasswordInput,String admin ) {
            this.emailInput.sendKeys(emailInput);
            this.passwordInput.sendKeys(passwordInput);
            confirmPassword.sendKeys(confirmPasswordInput);
            WebElement selectAdmin = driver.findElement(By.xpath("//*[@value='" + admin + "']"));
            selectAdmin.click();
            registrationButton.click();
        }
    }

