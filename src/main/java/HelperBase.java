import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){
        //WebElement element = wd.findElement(locator);
        WebElement element;
        element = new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        element.clear();
        element.sendKeys(text);
       // element.sendKeys(Keys.ENTER);

    }


    public void click(By locator){
        WebElement element;
        element = new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(locator));
        element.click();

    }
    public boolean isElementPresent(By locator){
        try{
            return wd.findElements(locator).size() > 0;

        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
