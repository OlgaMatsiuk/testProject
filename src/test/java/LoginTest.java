import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

//    @BeforeMethod
//    public void precondition(){
//
//        if(!app.getUser().isElementPresent(By.xpath("//img[@class='logo__img']"))){
//            System.out.println("The site did not open");
//            app.tearDown();
//
//        }
//
//    }

    @Test
    public void userFormPositive(){
        app.getUser().fillLoginForm("admin", "REZ1ucp2drw8gdp@efj");
        app.getUser().clickLoginButton();

    }

//    @Test
//    public void loginIsSuccesseful(){
//        app.getUser().pause(5000);
//
//         Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='admin ']")));
//
//    }

}
