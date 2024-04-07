package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
LoginPage loginPage;
HomePage homePage;

    private void loginTestMethod(String email,String password,boolean negativeCase,boolean invalidData){
        loginPage=new LoginPage(app.driver);
        loginPage.waitForVisibility();
        loginPage.loginInSystem(email,password);
        if (negativeCase) {
            if (invalidData) {
                loginPage.elementIsNotClickable();
            } else {
                loginPage.waitForErrorMassage();
            }
        } else {
            homePage = new HomePage(app.driver);
        }
    }
    @Test
    public void userCanLoginWithValidData(){
        loginTestMethod("alexberr9501@gmail.com","123qwert",false,false);
    }
    @Test
    public void userCanNotLoginWithInvalidEmail() {
        loginTestMethod("alexberr@gmail.com", "123qwert", true, true);
    }
}
