import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(WebElement elInput, String text)  {
       /*
         WebElement element = wd.findElement(locator);
         WebElement element;
         element = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(locator));
        */

        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(elInput));

        elInput.clear();
        elInput.sendKeys(text);
       // element.sendKeys(Keys.ENTER);

    }


    public void click(WebElement clickElement){
       // WebElement clickElement;
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(clickElement));
        clickElement.click();

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
