package Pages;

import Base.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTargetsSection extends HelperBase {
    public AddTargetsSection(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

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
    @FindBy(how = How.XPATH, using = "//*[@role='dialog']//input[@id='group-name']")
    public WebElement newTargetGroupName;
    @FindBy(how = How.XPATH, using = "//*[@class='cdk-overlay-pane']//button[@id='saveButton']")
    public WebElement saveBtnNewGroup;
    @FindBy(how = How.ID, using = "passwordInput")
    public WebElement APIKey;
    @FindBy(how = How.ID, using = "confirmPasswordInput")
    public WebElement confirmAPIKey;
    @FindBy(how =How.XPATH, using = "//form[@id='targetFormId']//button[@id='saveButton']")
    public WebElement saveButton;

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
