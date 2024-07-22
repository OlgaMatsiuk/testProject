import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.awaitility.Awaitility.await;

public class TargetsPage extends HelperBase{
    public TargetsPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);

    }
    @FindBy(how = How.XPATH, using = "//ul[@id='collapseAssets']//li")
    public WebElement targetsBtnInDashboard;

    @FindBy(how = How.XPATH, using = "//div[@id='first-panel']//table//tr")
    public List<WebElement> targets;
    @FindBy(how = How.ID, using = "addTargetButton")
    public WebElement addTargetBtn;
    @FindBy(how = How.XPATH, using = "//form[@id='targetFormId']//input[@id='name']")
    public WebElement targetName;
    @FindBy(how = How.XPATH, using = "//ng-select[@id='targetConfiguration']//input[@role='combobox']")
    public WebElement targetType;
    @FindBy(how = How.XPATH, using = "//ng-select[@placeholder='Please select groups']")
    public WebElement targetGroup;
    @FindBy(how = How.XPATH, using = "//div[@role='option']")
    public WebElement targetTypeOption;
    @FindBy(how = How.ID, using = "addNewGroupButton")
    public WebElement addNewGroupBtn;
//    @FindBy(how = How.XPATH, using = "//ng-select[@placeholder='Please select groups']")
//    public WebElement targetGroup;
    @FindBy(how = How.XPATH, using = "//*[@role='dialog']//input[@id='group-name']")
    public WebElement newTargetGroupName;
    @FindBy(how = How.XPATH, using = "//*[@class='cdk-overlay-pane']//button[@id='saveButton']")
    public WebElement saveBtnNewGroup;
    //form[@id='targetFormId']//button[@id='saveButton']
    @FindBy(how = How.ID, using = "passwordInput")
    public WebElement APIKey;
    @FindBy(how = How.ID, using = "confirmPasswordInput")
    public WebElement confirmAPIKey;
    @FindBy(how =How.XPATH, using = "//form[@id='targetFormId']//button[@id='saveButton']")
    public WebElement saveButton;

    public void clickTargetsBtnInDashboard(){
        click(targetsBtnInDashboard);
        waitForTableTargets();
    }
    public void clickAddButton(){
        click(addTargetBtn);
    }
    public boolean waitForTableTargets(){
        boolean isTablePressent = false;
        await().atMost(Duration.TWO_MINUTES).pollInterval(Duration.FIVE_SECONDS).ignoreExceptions().until(()->{
            return targets.size()>0 || isElementPresent(By.xpath("//div[@class='tab-content']//div[text()='No items found.']"));
        });
        isTablePressent=targets.size()>0 || isElementPresent(By.xpath("//div[@class='tab-content']//div[text()='No items found.']"));
        return isTablePressent;
    }
    public void typeTargetName(String name){
        type(targetName, name);
    }
    public void typeTargetType(String typeText){
        type(targetType, typeText);
    }

    public void getTargetTypeOption(String typeText){
        typeTargetType(typeText);
        click(targetTypeOption);
    }
    public void clickTargetGroup(){
        click(targetGroup);
    }
    public void clickAddNewTargetGroupBtn(){
        clickTargetGroup();
        click(addNewGroupBtn);
    }
    public void fillFormNewTargetGroup(String newNameGroup){
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(newTargetGroupName));
        type(newTargetGroupName, newNameGroup);
        click(saveBtnNewGroup);
    }
    public void typeAPIKey(String textAPI){
        type(APIKey, textAPI);
    }
    public void confirmAPIKey(String textAPI){
        type(confirmAPIKey, textAPI);
    }
    public void clickSaveButton(){
        click(saveButton);
    }



}
