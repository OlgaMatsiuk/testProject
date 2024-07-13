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

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search...']") //app-left-sidebar//input[@type='search']
    public WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//div[@class='collapse']//app-action-list/div[1]")
    public WebElement searchResult;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'round-btn btn-icon-behavior')]//i[@class='mdi mdi-pencil']")
    public WebElement pencilBtn;

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'form-control form-control-xsm w75')]")
    public WebElement taskNameInput;
    @FindBy(how = How.ID, using = "textarea-input")
    public WebElement textAreaLabel;

    @FindBy(how = How.XPATH, using = "//ng-select[@name='category']//input[@role='combobox']")
    public WebElement taskCategoryInput;

    @FindBy(how=How.XPATH, using = "//div[@class='ng-dropdown-panel-items scroll-host']")
    public WebElement optionTaskCategory;

    @FindBy(how=How.XPATH, using = "//div[@class='w-100 collapse-menu']//button[2]")
    public WebElement addNewActionsBtn;

    @FindBy(how=How.XPATH, using = "//div[@class='collapse'][2]")
    public WebElement sourcelocator;

    @FindBy(how=How.XPATH, using = "//div[@class='step-card p-1']")
    public WebElement clickAfterDragAndDrop;

    @FindBy(how=How.XPATH, using = "//div[@class='drop-area']")
    public WebElement destinationlocator;
    @FindBy(how=How.XPATH, using = "//div[@class='d-flex flex-column']//input[1]")
    public WebElement parametersInputLoopFor;

    @FindBy(how=How.XPATH, using = "//div[@class='d-flex flex-column']//input[2]")
    public WebElement parametersInputLoopOf;

    @FindBy(how=How.XPATH, using = "//div[@id='param-card']//input")
    public WebElement parametersMilliseconds;
    @FindBy(how=How.XPATH, using = "//div[@class='main-toolbar']//button[@title='Save']//i")
    public WebElement saveButton;


    public void search (String name) {
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
    public void clickNewActionsButton(){
        click(addNewActionsBtn);
    }
    public void dragAndDrop(){
        Actions action = new Actions(wd);
        action.dragAndDrop(sourcelocator, destinationlocator).build().perform();
        click(clickAfterDragAndDrop);
    }
    public void parametersLoopFor(String parameters){
        type(parametersInputLoopFor, parameters);
    }
    public void parametersLoopOf(String parameters){
        type(parametersInputLoopOf, parameters);
    }
    public void parametersMilliseconds(String parameters){
        type(parametersMilliseconds, parameters);
    }
    public void saveButton(){
        click(saveButton);
    }

}
