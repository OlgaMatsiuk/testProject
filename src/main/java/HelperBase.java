import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(WebElement elInput, String text)  {
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(elInput));
        elInput.clear();
        elInput.sendKeys(text);
    }

    public void click(WebElement clickElement){
       // WebElement clickElement;
        new WebDriverWait(wd, 15).until(ExpectedConditions.visibilityOf(clickElement));
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

    public void refresh(){
        wd.navigate().refresh();
    }

    public void pause(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
