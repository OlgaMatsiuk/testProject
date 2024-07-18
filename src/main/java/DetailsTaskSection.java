import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsTaskSection extends HelperBase{
    public DetailsTaskSection(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }
    @FindBy(how = How.XPATH, using = "//div[@class='third-line']//span[2]")
    public WebElement status;
    @FindBy(how = How.XPATH, using = "//div[@class='text-truncate']//a")
    public WebElement taskName;
    @FindBy(how = How.XPATH, using = "//div[@class='third-line']//small[2]")
    public WebElement errors;
    @FindBy(how = How.XPATH, using = "//div[@class='third-line']//small[3]")
    public WebElement warning;
    @FindBy(how = How.XPATH, using = "//div[@class='third-line']//small[4]")
    public WebElement message;

    public String  getStatus(){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(status));
        while (status.getText().equals("In progress")){} //(статус долго крутиться In progress и только потом меняется. Я придумала зациклить пока не поменяется статус -знаю что корявое решение)
        return status.getText();
    }
    public String  getTaskName(){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(taskName));
        return taskName.getText();
    }
    public String  getErrorsInRun(){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(errors));
        return errors.getText();
    }
    public String  getWarningInRun(){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(warning));
        return warning.getText();
    }
    public String  getMessageInRun(){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }

}
