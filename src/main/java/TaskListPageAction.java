import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

public class TaskListPageAction extends HelperBase{


    public TaskListPageAction(WebDriver wd) {
        super(wd);
        addTaskPageSection = new AddTaskPageSection(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@id='collapseTasks']//li")
    public WebElement addTaskList;

    @FindBy(how = How.XPATH, using = "//button[text()=' Add task ']")
    public WebElement addTaskListBtn;

    private final AddTaskPageSection addTaskPageSection;



    public void addTaskList() {
        click(addTaskList);

    }

    public void addTaskListButton () {
         click(addTaskListBtn);
    }


}


