import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

public class TaskListPageAction extends HelperBase{

    public TaskListPageAction(WebDriver wd) {
        super(wd);
    }

    public void search (String name) {
        type(By.xpath("//input[@placeholder='Search...']"), name);
        click(By.xpath("//div[@class='collapse']//app-action-list/div[1]"));
    }



}
