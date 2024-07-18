import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTaskTest extends TestBase{
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    int countUsageRun, countUsageAfterRun;
    String newTaskName= "-" + i;
    String currentName;
    int amountTaskBefore=0, amountTaskAfter=0;
    TaskListPageAction taskListPageAction;
    AddTaskPageSection addTaskPageSection;
    DetailsTaskSection detailsTaskSection;


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
        addTaskPageSection.searchInSidebar("sleep");
        addTaskPageSection.dragAndDrop();

    }

    @Test(priority = 80)
    public void parametersLoopForOfTestInAction(){
        addTaskPageSection.parametersLoopFor("3");
        addTaskPageSection.parametersLoopOf("");
    }
    @Test(priority = 90)
    public void parametersMillisecondsTest(){
        addTaskPageSection.parametersMilliseconds("5000");
    }
    @Test(priority = 100)
    public void saveTask(){
        addTaskPageSection.saveButton();
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
        addTaskPageSection.pause();
        Assert.assertEquals(detailsTaskSection.getStatus(),"Complete");
    }
    @Test(priority =210)
    public void checkUsageIncreased(){
        goToTaskList();
        countUsageRun= taskListPageAction.getNumberUsageInTask();
        runTask();
        goToTaskList();
        addTaskPageSection.refresh(); //(метод goToTaskList не обновил количество, пришлось рефреш делать)
        addTaskPageSection.pause(); //(без паузы количество не успевает поменяться)
        countUsageAfterRun= taskListPageAction.getNumberUsageInTask();
        Assert.assertEquals(countUsageAfterRun-countUsageRun, 1);
    }
    @Test(priority =215)
    public void typeNameInSearch(){
        goToTaskList();
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
        Assert.assertFalse(taskListPageAction.isTaskPresent("New task"+newTaskName));
    }
}
