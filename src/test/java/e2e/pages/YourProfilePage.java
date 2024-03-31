package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourProfilePage extends BasePage{
    public YourProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@alt='Logo']")
    WebElement header;
    @FindBy(xpath = "//*[@data-test='userProfileForm']")
    WebElement userProfileForm;
    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement editButton;
    @FindBy(xpath = "//*[@data-test='profileName']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@data-test='profileSurname']")
    WebElement surnameInput;
    @FindBy(xpath = "//*[@data-test='profileGender']//option[text()='MALE']")
    WebElement genderMale;
    @FindBy(xpath = "//*[@data-test='profileGender']//option[text()='FEMALE']")
    WebElement genderFemale;
    @FindBy(xpath = "//*[@id='birthDate']")
    WebElement birthDateInput;
    @FindBy(xpath = "//*[@name='phone']")
    WebElement phoneInput;
    @FindBy(xpath = "//*[@data-test='profileChangePasswordButton']")
    WebElement changePassword;
    @FindBy(xpath = "//*[@data-test='profileSaveButton']")
    WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(userProfileForm);
        getWait().forVisibility(editButton);
        Assert.assertTrue(userProfileForm.isDisplayed());
        Assert.assertTrue(editButton.isDisplayed());
    }
    public void updateUserProfile(String name,String surname,String birthdate,String phone){
        editButton.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        surnameInput.clear();
        surnameInput.sendKeys(surname);
        genderMale.click();
        birthDateInput.clear();
        birthDateInput.sendKeys(birthdate);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        saveButton.click();
    }
    public void elementIsDisabled(){
        boolean isPhoneInputDisabled = phoneInput.getAttribute("disabled") != null;
        Assert.assertFalse(isPhoneInputDisabled);
    }
    public void goToHomePage(){
        header.click();
    }



}
