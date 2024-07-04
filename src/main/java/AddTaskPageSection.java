import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPageSection extends HelperBase {

    public AddTaskPageSection(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search...']")
    public WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//div[@class='collapse']//app-action-list/div[1]")
    public WebElement searchResult;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'round-btn btn-icon-behavior')]//i[@class='mdi mdi-pencil']")
    public WebElement pencilBtn;

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'form-control form-control-xsm')]")
    public WebElement taskNameInput;

    @FindBy(how = How.XPATH, using = "//textarea[@id='textarea-input']")
    public WebElement textAreaLabel;



    public void search (String name) {
        type(searchInput, name);
        click(searchResult);
    }
    public void inputNewTaskName(String newName){
        click(pencilBtn);
        type(taskNameInput,newName);
    }

    public void clickPencilBtn(){
        click(pencilBtn);
    }
           // app.getUser().type(textAreaLabel,"I want to add my new task");
       // app.getUser().type(By.xpath("//textarea[@id='textarea-input']"),"I want to add my new task");

    public void inputDescription(String description){
        type(textAreaLabel, description);
    }




}