import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    private String username;
    private String password;

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
        username = "admin";
        password = "REZ1ucp2drw8gdp@efj";
    }

    @AfterSuite
    public void stop(){
        app.tearDown();
    }

    public void login(){
        app.getUser().fillLoginForm(username, password);
        app.getUser().clickLoginButton();
    }

}
