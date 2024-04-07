package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@href='/about']")
    WebElement aboutButton;
    @FindBy(xpath = "//*[@class='about-box']")
    WebElement aboutBox;

}
