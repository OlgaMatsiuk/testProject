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
    public void login(){
        app.getLoginPage().fillLoginForm(username,password);
        app.getLoginPage().clickLoginButton();
    }
}
