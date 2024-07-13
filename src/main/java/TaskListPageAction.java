import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskListPageAction extends HelperBase{

    AddTaskPageSection addTaskPageSection;
    DetailsTaskPage detailsTaskPage;

    public TaskListPageAction(WebDriver wd) {
        super(wd);
        addTaskPageSection = new AddTaskPageSection(wd);
        detailsTaskPage = new DetailsTaskPage(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@id='collapseTasks']//li")
    public WebElement addTaskList;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add task')]")
    public WebElement addTaskBtn;

    @FindBy(how = How.XPATH, using = "//table[@class='table tbl-break-word']//tr")
    public WebElement task;
    @FindBy(how=How.XPATH, using = "//table[@class='table tbl-break-word']//button[contains(@class, 'btn btn-sm btn-secondary mr-2')]")
    public WebElement runButton;
    @FindBy(how=How.CSS, using = "button[class='btn btn-success']")
    public WebElement runButtonModalWindow;
    @FindBy(how=How.XPATH, using = "//a[@class='link-primary']")
    public WebElement detailsButton;


    public void addTaskList() {
        click(addTaskList);
    }

    public void addTaskListButton () {
         click(addTaskBtn);
    }

    public int getSizeTask()  {
        pause();
        if (isElementPresent(By.xpath("//span[normalize-space()='No items found.']")))
            return 0;
        else {
            new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(task));
            return wd.findElements(By.xpath("//table[@class='table tbl-break-word']//tr")).size();
        }
    }
    public void runTaskClick(){
        pause();
        click(runButton);
        pause();
        click(runButtonModalWindow);
        pause();
        click(detailsButton);
    }
    public AddTaskPageSection getAddTaskPageSection() {
        return addTaskPageSection;
    }
    public DetailsTaskPage getDetailsTaskPage() {
        return detailsTaskPage;
    }
}


