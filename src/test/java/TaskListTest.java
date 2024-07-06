import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskListTest extends TestBase{
    //TaskListPageAction taskList;
    //LoginPageAction user;

//    @BeforeClass
//    public void preconditions(){
//        taskList = new TaskListPageAction(wd);
//
//    }


    @BeforeMethod
    public void precondition(){
        app.getUser().login("admin", "REZ1ucp2drw8gdp@efj");
    }

    @Test
    public void addTaskList(){
        app.getTaskList().addTaskList();
        app.getTaskList().addTaskListButton();


    }


}
