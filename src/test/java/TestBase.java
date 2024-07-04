import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {
    //WebDriver wd;

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setUp() throws IOException {
        app.init();

    }
    @AfterSuite
    public void stop(){
        app.tearDown();
    }


}
