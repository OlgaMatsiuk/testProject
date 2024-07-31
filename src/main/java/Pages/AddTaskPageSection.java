package Pages;

import Base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTaskPageSection extends HelperBase {

    public AddTaskPageSection(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.XPATH, using = "//app-left-sidebar[@class='left-sidebar']//input")
    public WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//div[@class='collapse']//app-action-list/div[1]")
    public WebElement searchResult;
    @FindBy(how = How.XPATH, using = "//div[@class='main-wrapper']//button[contains(@class,'round-btn')]")
    public WebElement pencilBtn;
    @FindBy(how = How.XPATH, using = "//app-editable-input[contains(@class,'ng-untouched')]//input")
    public WebElement taskNameInput;
    @FindBy(how = How.ID, using = "textarea-input")
    public WebElement textAreaLabel;
    @FindBy(how = How.XPATH, using = "//ng-select[@name='category']//input[@role='combobox']")
    public WebElement taskCategoryInput;
    @FindBy(how=How.XPATH, using = "//ng-dropdown-panel//div[contains(@class,'ng-dropdown-panel-items')]")
    public WebElement optionTaskCategory;
    @FindBy(how=How.XPATH, using = "//*[@class='left-sidebar']//div[@class='collapse'][2]//div")
    public WebElement sourceLocator;
    @FindBy(how=How.XPATH, using = "//div[contains(@class,'step-card')]")
    public WebElement clickAfterDragAndDrop;
    @FindBy(how=How.XPATH, using = "//div[@class='ng-star-inserted'][2]//div[contains(@class,'step-card')]")
    public WebElement clickAfterDragAndDropSecond;
    @FindBy(how=How.XPATH, using = "//div[@class='drop-area']")
    public WebElement destinationLocator;
    @FindBy(how=How.XPATH, using = "//div[@class='ng-star-inserted']//div[@class='drop-area']")
    public WebElement destinationLocatorSecond;
    @FindBy(how=How.XPATH, using = "//div[@class='d-flex flex-column']//input[1]")
    public WebElement parametersInputLoopFor;
    @FindBy(how=How.XPATH, using = "//div[@class='d-flex flex-column']//input[2]")
    public WebElement parametersInputLoopOf;
    @FindBy(how=How.XPATH, using = "//div[@id='param-card']//input")
    public WebElement parametersMilliseconds;
    @FindBy(how=How.XPATH, using = "//div[@class='main-toolbar']//button[@title='Save']")
    public WebElement saveButton;
    @FindBy(how=How.XPATH, using = "//div[@class='target-select']//input[@role='combobox']")
    public WebElement targetSelectInput;
    @FindBy(how = How.XPATH, using = "//app-target-select//label[2]//input")
    public WebElement radioButtonTargetsGroup;
    @FindBy(how = How.XPATH, using = "//app-target-select//label[1]//input")
    public WebElement radioButtonTargetsSingle;
    @FindBy(how = How.XPATH, using = "//ng-dropdown-panel/div[contains(@class,'ng-dropdown-panel-items')]")
    public WebElement targetsOption;



    public void searchInSidebar (String name) {
        type(searchInput, name);
        click(searchResult);
    }
    public void typeNewTask(WebElement elementInput, String name){
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(elementInput));
        elementInput.sendKeys(name);
    }

    public void inputNewTaskName(String name){
        clickPencilBtn();
        typeNewTask(taskNameInput, name);
    }
    public void clickPencilBtn(){
        click(pencilBtn);
    }

    public void inputDescription(String description){
        type(textAreaLabel, description);
    }

    public void inputTaskCategory(String category){
        type(taskCategoryInput, category);
        click(optionTaskCategory);
    }
    public String getTaskNameFromToolbar(){
        return wd.findElement(By.xpath("//div[@class='task-title mr-1']")).getText();
    }
    public void dragAndDropAction(){
        Actions action = new Actions(wd);
        action.dragAndDrop(sourceLocator, destinationLocator).build().perform();
        click(clickAfterDragAndDrop);
    }
    public void dragAndDropActionSecond(){
        Actions action = new Actions(wd);
        action.dragAndDrop(sourceLocator, destinationLocatorSecond).build().perform();
        click(clickAfterDragAndDropSecond);
    }
    public void setParametersLoopFor(String parameters){
        type(parametersInputLoopFor, parameters);
    }
    public void setParametersLoopOf(String parameters){
        type(parametersInputLoopOf, parameters);
    }
    public void setParametersMilliseconds(String parameters){
        type(parametersMilliseconds, parameters);
    }
    public void clickOfSaveButton(){
        click(saveButton);
    }
    public void searchTargetsInRightSidebarInTaskList(String target){
        click(targetSelectInput);
        type(targetSelectInput,target);
    }
    public boolean isTargetsOptionPresent(){
        return isElementPresent(By.xpath("//ng-dropdown-panel/div[contains(@class,'ng-dropdown-panel-items')]"));
    }
    public void selectTargets(){
        if(isTargetsOptionPresent()){
            click(targetsOption);
        }
    }

    public void clickByRadioBtnTargetsGroup(){
        click(radioButtonTargetsGroup);
    }
    public void clickByRadioBtnTargetsSingle(){
        click(radioButtonTargetsSingle);
    }

}
