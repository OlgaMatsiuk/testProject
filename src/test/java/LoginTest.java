import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void userFormPositive(){
        app.getLoginPage().login();
    }
}
