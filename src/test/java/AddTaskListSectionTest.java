import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTaskListSectionTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getUser().login("admin", "REZ1ucp2drw8gdp@efj");
        app.getTaskList().addTaskList();
        app.getTaskList().addTaskListButton();
    }

    @Test
    public void testAddTaskList(){
        app.getAddTaskPageSection().clickPencilBtn();
        app.getAddTaskPageSection().inputNewTaskName("First name");
        app.getAddTaskPageSection().inputDescription("I want to add my new task");
        app.getAddTaskPageSection().inputTaskCategory("Default");

    }

}
