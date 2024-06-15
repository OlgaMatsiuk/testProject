import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver wd;

    @BeforeTest
    public void precondition(){
        wd = new ChromeDriver();
        wd.get("https://testing.cloud.cyberm8.com/");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void click (By locator){
        wd.findElement(locator).click();
    }


    @Test
    public void testMethod(){
        type(By.id("username"), "admin");
        type(By.id("password"), "REZ1ucp2drw8gdp@efj");
        click(By.id("loginBtn"));

    }

    @AfterTest
    public void postcondition(){

        //wd.quit();

    }


}
