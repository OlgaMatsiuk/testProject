import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TaskListPageAction extends HelperBase{

    AddTaskPageSection addTaskPageSection;

    public TaskListPageAction(WebDriver wd) {
        super(wd);
        addTaskPageSection = new AddTaskPageSection(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@id='collapseTasks']//li")
    public WebElement addTaskList;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add task')]")
    public WebElement addTaskBtn;

    public void addTaskList() {
        click(addTaskList);
    }

    public void addTaskListButton () {
         click(addTaskBtn);
    }

    public AddTaskPageSection getAddTaskPageSection() {
        return addTaskPageSection;
    }

}


