import Pages.AddTaskPageSection;
import Pages.DetailsTaskSection;
import Pages.TaskListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTaskTest extends TestBase{
    int randomNumber = (int)(System.currentTimeMillis()/1000)%360;
    int countUsageRun, countUsageAfterRun;
    String newTaskName= "-sleep-" + randomNumber;
    String currentName;
    int amountTaskBefore=0, amountTaskAfter=0;
    String nameOfAction="sleep";
    public TaskListPage taskListPageAction;
    public AddTaskPageSection addTaskPageSection;
    public DetailsTaskSection detailsTaskSection;


    @BeforeClass
    public void precondition(){
        login();
        taskListPageAction = app.getTaskListPage();
        addTaskPageSection = taskListPageAction.getAddTaskPageSection();
        detailsTaskSection = taskListPageAction.getDetailsTaskSection();
    }

    @Test(priority = 10)
    public void goToTaskList(){
        app.getTaskListPage().clickTaskListBtnInDashboard();
    }
    @Test(priority = 20)
    public void getAmountTaskBefore(){
        amountTaskBefore= taskListPageAction.getAmountOfTasks();
    }
    @Test(priority = 30)
    public void clickAddTaskButton(){
        taskListPageAction.clickAddTaskButton();
    }
    @Test(priority = 40)
    public void inputTaskName(){
        addTaskPageSection.inputNewTaskName(newTaskName);
    }
    @Test(priority = 50)
    public void inputTaskDescription(){
        addTaskPageSection.inputDescription("I want to add my new task");
    }
    @Test(priority = 60)
    public void inputTaskCategory(){
        addTaskPageSection.inputTaskCategory("Default");
    }
    @Test(priority = 70)
    public void addActionSidebar(){
        addTaskPageSection.searchInSidebar(nameOfAction);
        addTaskPageSection.dragAndDropAction();
    }
    @Test(priority = 80)
    public void parametersLoopForOfTestInAction(){
        addTaskPageSection.setParametersLoopFor("3");
        addTaskPageSection.setParametersLoopOf("");
    }
    @Test(priority = 90)
    public void parametersMillisecondsTest(){
        addTaskPageSection.setParametersMilliseconds("5000");
    }
    @Test(priority = 100)
    public void saveTask(){
        addTaskPageSection.clickOfSaveButton();
    }
    @Test(priority = 110)
    public void taskNameFromToolbar(){
        currentName=addTaskPageSection.getTaskNameFromToolbar();
    }
    @Test(priority = 120)
    public void getAmountTaskAfter(){
        goToTaskList();
        amountTaskAfter=taskListPageAction.getAmountOfTasks();
    }
    @Test(priority = 130)
    public void NewTaskPresentTest(){
        Assert.assertEquals(amountTaskAfter-amountTaskBefore,1);
    }
    @Test(priority = 140)
    public void runTask(){
        goToTaskList();
        taskListPageAction.runTaskClick();
    }
    @Test(priority = 150)
    public void nameTaskTest(){
        Assert.assertEquals("New task"+newTaskName, currentName);
    }
    @Test(priority = 160)
    public void checkNameInDetailsTest(){
        Assert.assertEquals(detailsTaskSection.getTaskName(), currentName);
    }
    @Test(priority = 170)
    public void errorsTest(){
        Assert.assertEquals(detailsTaskSection.getErrorsInRun(),"0 error(s)");
    }
    @Test(priority = 180)
    public void warningTest(){
        Assert.assertEquals(detailsTaskSection.getWarningInRun(),"0 warning(s)");
    }
    @Test(priority = 190)
    public void messageTest(){
        Assert.assertEquals(detailsTaskSection.getMessageInRun(),"0 message(s)");
    }
    @Test(priority = 200)
    public void statusTaskTest(){
        Assert.assertTrue(detailsTaskSection.waitForStatusWillBeExpected("Complete"),"Status is not expected");
    }
    @Test(priority =210)
    public void checkUsageIncreased(){
        goToTaskList();
        countUsageRun= taskListPageAction.getNumberUsageInTask();
        runTask();
        goToTaskList();
        addTaskPageSection.refresh();
        taskListPageAction.waitForTable();
        countUsageAfterRun= taskListPageAction.getNumberUsageInTask();
        Assert.assertEquals(countUsageAfterRun-countUsageRun, 1);
    }
    @Test(priority =215)
    public void typeNameInSearch(){
        taskListPageAction.typeNameTaskInSearch("New task"+newTaskName);
        Assert.assertEquals(taskListPageAction.getTaskName(), "New task"+newTaskName);
    }
    @Test(priority =220)
    public void deleteTask(){
        goToTaskList();
        taskListPageAction.deleteTask();
    }
    @Test(priority =230)
    public void isTaskWasDeleted(){
        taskListPageAction.waitForTable();
        Assert.assertFalse(taskListPageAction.isTaskPresent("New task"+newTaskName));
    }
}
