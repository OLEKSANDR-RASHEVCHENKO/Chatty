package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='header__user header__menu']")
    WebElement headerUserMenu;

    @FindBy(xpath = "//*[@class='dropdown-menu']")
    WebElement dropdownMenu;

    @FindBy(xpath = "//*[@href=/userprofile]")
    WebElement userProfile;

    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement editProfileButton;



    @FindBy(xpath = "//*[@name='name']")
    WebElement userNameInput;

    @FindBy(xpath = "//*[@name='surname']")
    WebElement userSurnameInput;

    @FindBy(xpath = "//*[@id='birthDate']")
    WebElement birthdayInput;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@id='gender']")
    WebElement genderInput;

    @FindBy(xpath = "//*[@data-test='profileChangePasswordButton']")
    WebElement changePassword;

    @FindBy(xpath = "//*[@placeholder='Old password']")
    WebElement oldPasswordInput;

    @FindBy(xpath = "//*[@placeholder='New password']")
    WebElement newPasswordInput;

    @FindBy(xpath = "//*[@placeholder='Confirm new password']")
    WebElement confirmNewPasswordInput;

    @FindBy(xpath = "//*[@class='PasswordModal_pass_btn__eGL9h']")
    WebElement savePassword;

    @FindBy(xpath = "//*[@data-test='profileSaveButton']")
    WebElement profileSaveButton;

    @Step("Wait for loading edit page")
    public void waitForLoading() {
        getWait().forVisibility(editProfileButton);

    }
    @Step("Open edit profile form ")
    public void openEditProfilePage(){
        headerUserMenu.click();
        WebElement profile = driver.findElement(By.xpath("//*[@href='/userprofile']"));
        profile.click();
        getWait().forVisibility(editProfileButton);

    }

    @Step("Edit user`s profile")
    public void editProfile(String editName, String editSurname, String editBirthday,String editPhone, String editGender,String oldPass, String newPass, String confirmNewPass){
        editProfileButton.click();
        getWait().forVisibility(userNameInput);
        userNameInput.clear();
        userNameInput.sendKeys(editName);
        userSurnameInput.clear();
        userSurnameInput.sendKeys(editSurname);
        birthdayInput.clear();
        birthdayInput.sendKeys(editBirthday);
        birthdayInput.clear();
        birthdayInput.click();
        birthdayInput.sendKeys(editBirthday);
        phoneInput.clear();
        phoneInput.sendKeys(editPhone);
        genderInput.click();
        WebElement selectGender = driver.findElement(By.xpath("//*[@value='" + editGender + "']"));
        selectGender.click();
        setChangePassword(oldPass,newPass, confirmNewPass);
        profileSaveButton.click();
    }

    public void setChangePassword(String oldPassword, String newPassword, String confirmNewPassword){
        changePassword.click();
        getWait().forVisibility(oldPasswordInput);
        oldPasswordInput.sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        confirmNewPasswordInput.sendKeys(confirmNewPassword);
        savePassword.click();

    }

}
