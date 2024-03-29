package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeblogPage extends BasePage{
    public HomeblogPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@alt='Logo']")
    public WebElement logo;

    @Step("Wait for loading homeblog page")
    public void waitForLoading(){
        getWait().forVisibility(logo);
    }
}
