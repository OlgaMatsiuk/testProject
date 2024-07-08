import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTaskTest extends TestBase{

    @BeforeClass
    public void precondition(){
        login();
    }

    @Test(priority = 1)
    public void goToTaskList(){
        app.getTaskList().addTaskList();
    }

    @Test(priority = 2)
    public void clickAddTaskButton(){
        app.getTaskList().addTaskListButton();
    }

    @Test(priority = 3)
    public void inputTaskName(){
        app.getTaskList().getAddTaskPageSection().inputNewTaskName("First name");
    }
    @Test(priority = 4)
    public void inputTaskDescription(){
        app.getTaskList().getAddTaskPageSection().inputDescription("I want to add my new task");
    }
    @Test(priority = 5)
    public void inputTaskCategory(){
        app.getTaskList().getAddTaskPageSection().inputTaskCategory("Default");
    }
    @Test(priority = 6)
    public void newActionsTest(){
        app.getTaskList().getAddTaskPageSection().clickNewActionsButton();
    }
    @Test(priority = 7)
    public void searchTest(){
        app.getTaskList().getAddTaskPageSection().search("sleep");
    }
    @Test(priority = 8)
    public void dragAndDropTest(){
        app.getTaskList().getAddTaskPageSection().dragAndDrop();
    }
    @Test(priority = 9)
    public void parametersLoopForOfTest(){
        app.getTaskList().getAddTaskPageSection().parametersLoopFor("5");
        app.getTaskList().getAddTaskPageSection().parametersLoopOf("10");
    }
    @Test(priority = 10)
    public void parametersMillisecondsTest(){
        app.getTaskList().getAddTaskPageSection().parametersMilliseconds("5000");
    }
    @Test(priority = 11)
    public void saveButtonTest(){
        app.getTaskList().getAddTaskPageSection().saveButton();
    }

}
