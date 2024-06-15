import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setUp() throws IOException {
        app.init();
    }


}
