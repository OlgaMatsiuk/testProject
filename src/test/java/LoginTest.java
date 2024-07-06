import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


//    @BeforeClass
//    public void precondition(){
//        user = new LoginPageAction(wd);
//    }

    @Test
    public void userFormPositive(){

        app.getUser().login("admin", "REZ1ucp2drw8gdp@");

    }

//    @Test
//    public void loginIsSuccesseful(){
//        app.getUser().pause(5000);
//
//         Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='admin ']")));
//
//    }

}
