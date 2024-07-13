import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTaskTest extends TestBase{
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    String newTaskName= "-" + i;
    String currentName;
    int sizeTaskBefore=0, sizeTaskAfter=0;
    TaskListPageAction taskListPageAction;

    @BeforeClass
    public void precondition(){
        app.getLoginPage().login();
        taskListPageAction = app.getTaskListPage();
    }

    @Test(priority = 1)
    public void goToTaskList(){
        app.getTaskListPage().addTaskList();
    }
    @Test(priority = 2)
    public void checkSizeTaskBefore(){
        sizeTaskBefore= taskListPageAction.getSizeTask();
    }

    @Test(priority = 3)
    public void clickAddTaskButton(){
        taskListPageAction.addTaskListButton();
    }

    @Test(priority = 4)
    public void inputTaskName(){
        taskListPageAction.getAddTaskPageSection().inputNewTaskName(newTaskName);
    }
    @Test(priority = 5)
    public void inputTaskDescription(){
        taskListPageAction.getAddTaskPageSection().inputDescription("I want to add my new task");
    }
    @Test(priority = 6)
    public void inputTaskCategory(){
        taskListPageAction.getAddTaskPageSection().inputTaskCategory("Default");
    }
    @Test(priority = 7)
    public void newActionsClick(){
        taskListPageAction.getAddTaskPageSection().clickNewActionsButton();
    }
    @Test(priority = 8)
    public void searchAction(){
        taskListPageAction.getAddTaskPageSection().search("sleep");
    }
    @Test(priority = 9)
    public void dragAndDropAction(){
        taskListPageAction.getAddTaskPageSection().dragAndDrop();
    }
    @Test(priority = 10)
    public void parametersLoopForOfTest(){
        taskListPageAction.getAddTaskPageSection().parametersLoopFor("5");
        taskListPageAction.getAddTaskPageSection().parametersLoopOf("10");
    }
    @Test(priority = 11)
    public void parametersMillisecondsTest(){
        taskListPageAction.getAddTaskPageSection().parametersMilliseconds("5000");
    }
    @Test(priority = 12)
    public void saveButtonTest(){
        taskListPageAction.getAddTaskPageSection().saveButton();
    }
    @Test(priority = 13)
    public void saveNameTaskTest(){
        currentName=taskListPageAction.getDetailsTaskPage().saveNameTask();
    }
    @Test(priority = 14)
    public void getSizeTaskAfter(){
        goToTaskList();
        sizeTaskAfter=taskListPageAction.getSizeTask();
    }

    @Test(priority = 15)
    public void checkNewTaskPresent(){
        Assert.assertEquals(sizeTaskAfter-sizeTaskBefore,1);
    }

    @Test(priority = 15)
    public void runTask(){
        goToTaskList();
        app.getTaskListPage().runTaskClick();
    }

    @Test(priority = 16)
    public void checkNameTaskTest(){
        Assert.assertEquals("New task"+newTaskName, currentName);
    }

}
