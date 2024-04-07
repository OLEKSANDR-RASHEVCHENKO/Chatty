package e2e_Teti.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanel extends BasePage{
    public AdminPanel(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='header__user header__menu']")
    WebElement headerUserMenu;

    @FindBy(xpath = "//*[@data-test='searchEmailInput']")
    WebElement searchEmailInput;

    @FindBy(xpath = "//*[@data-test='searchEmailButton']")
    WebElement searchEmailButton;

    @FindBy(xpath = "//*[@data-icon='trash']")
    WebElement deleteButton;

    @Step("Open admin panel ")
    public void openAdminPanel(){
        headerUserMenu.click();
        WebElement adminPanel = driver.findElement(By.xpath("//*[@href='/users']"));
        adminPanel.click();
        getWait().forVisibility(searchEmailInput);
    }

    public void deleteProfile(){
        searchEmailInput.sendKeys();
        searchEmailButton.click();
    }

    public void waitForSearchEmailInput(){
        getWait().forVisibility(searchEmailInput);
    }
}
