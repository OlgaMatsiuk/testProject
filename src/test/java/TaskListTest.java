import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskListTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getUser().fillLoginForm("admin", "REZ1ucp2drw8gdp@efj");
        app.getUser().clickLoginButton();
    }

    @Test
    public void addTaskList(){
        app.getUser().click(By.xpath("//ul[@id='collapseTasks']//li"));
        app.getUser().click(By.xpath("//button[text()=' Add task ']"));
        app.getUser().click(By.xpath("//button[@class='round-btn btn-icon-behavior align-self-start']//i[@class='mdi mdi-pencil']"));
        //app.getUser().type(By.xpath("//div[@class='task-name font-weight-500']"), "First task");

        app.getUser().type(By.xpath("//textarea[@id='textarea-input']"),"I want to add my new task");
        app.getTaskList().search("aws");

    }


}
