import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void fillLoginForm(String name, String password) {
        type(By.id("username"),name);
        type(By.id("password"),password);

    }

    public void clickLoginButton(){
        click(By.id("loginBtn"));
    }


}
