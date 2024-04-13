package e2e.test;

import e2e.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setupTest() {
        app.init();
    }
    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
