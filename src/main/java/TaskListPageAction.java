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


public class TaskListPageAction extends HelperBase{

    AddTaskPageSection addTaskPageSection;
    DetailsTaskSection detailsTaskSection;

    public TaskListPageAction(WebDriver wd) {
        super(wd);
        addTaskPageSection = new AddTaskPageSection(wd);
        detailsTaskSection = new DetailsTaskSection(wd);
        PageFactory.initElements(wd, this);
    }
    public AddTaskPageSection getAddTaskPageSection() {
        return addTaskPageSection;
    }

    public DetailsTaskSection getDetailsTaskSection() {
        return detailsTaskSection;
    }


    @FindBy(how = How.XPATH, using = "//ul[@id='collapseTasks']//li")
    public WebElement taskListBtnInDashboard;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add task')]")
    public WebElement addTaskBtn;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'table')]//tr")
    public List<WebElement> tasks;
    @FindBy(how = How.XPATH, using = "//table//tr//a")
    public WebElement taskName;
    @FindBy(how=How.XPATH, using = "//table[contains(@class,'table')]//button[contains(@class,'btn-secondary')]")
    public WebElement runButton;
    @FindBy(how=How.XPATH, using = "//div[@id='button']//button[contains(@class,'btn-success')]")
    public WebElement runButtonModalWindow;
    @FindBy(how=How.XPATH, using = "//a[@class='link-primary']")
    public WebElement detailsButton;

    @FindBy(how=How.XPATH, using = "//div[@class='btn-group']//button[@title='delete']")
    public WebElement deleteTaskBtn;

    @FindBy(how=How.XPATH, using = "//*[@role='dialog']//button[2]")
    public WebElement confirmDeleteBtn;

    @FindBy(how=How.XPATH, using = "//input[@id='searchInput']")
    public WebElement searchTask;

    public void clickTaskListBtnInDashboard() {
        click(taskListBtnInDashboard);
        waitForTable();
    }

    public void clickAddTaskButton () {
         click(addTaskBtn);
    }

    public int getAmountOfTasks()  {
        waitForTable();
        if (isElementPresent(By.xpath("//span[normalize-space()='No items found.']")))
            return 0;
        else {
            new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(tasks.get(0)));
            return tasks.size();
        }
    }
    public void typeNameTaskInSearch(String name){
        click(searchTask);
        type(searchTask, name);
        waitForTable();
    }
    public String getTaskName(){
        new WebDriverWait(wd, 15).until(ExpectedConditions.elementToBeClickable(taskName));
        return taskName.getText().trim();
    }
    //TODO Olga fix method
    public boolean isTaskPresent(String name){
        return tasks.stream().map(task -> getTextOfTask(task).equalsIgnoreCase(name)).count()==1;
    }
    public void runTaskClick(){
        pause();
        click(runButton);
        click(runButtonModalWindow);
        click(detailsButton);
    }
    public Integer getNumberUsageInTask(){

        new WebDriverWait(wd, 20).until(ExpectedConditions.visibilityOf(tasks.get(0)));
        WebElement element=wd.findElement(By.xpath("//table//tr//span//span")); //тут не ставила классы в локаторе,т.к при каждом запуске ран классы меняются -странно так)
        String[] elements=element.getText().split(":");
        return Integer.parseInt(elements[1].trim());
    }
    public void deleteTask(){
        click(deleteTaskBtn);
        new WebDriverWait(wd, 20).until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn));
        click(confirmDeleteBtn);
    }
    public boolean waitForTable(){
        boolean isTablePressent;
        await().atMost(Duration.TWO_MINUTES).pollInterval(Duration.FIVE_SECONDS).ignoreExceptions().until(()->{
            return tasks.size()>0 || isElementPresent(By.xpath("//span[normalize-space()='No items found.']"));
        });
        isTablePressent=tasks.size()>0 || isElementPresent(By.xpath("//span[normalize-space()='No items found.']"));
        return isTablePressent;
    }
    private String getTextOfTask(WebElement task){
        return task.findElement(By.xpath("//a[contains(@class, 'details-lnk')")).getText();
    }
}



