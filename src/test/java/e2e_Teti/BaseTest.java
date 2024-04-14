package e2e_Teti;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static e2e.ApplicationManager app = new e2e.ApplicationManager();

    @BeforeMethod
    public void setupTest() {
        app.init();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        app.stop(result.isSuccess());
    }
}
