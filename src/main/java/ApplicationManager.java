import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;

    TaskListPageAction taskList;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://testing.cloud.cyberm8.com/");
       // wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        user = new HelperUser(wd);
        taskList = new TaskListPageAction(wd);

    }
    public void tearDown() {
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public TaskListPageAction getTaskList() {
        return taskList;
    }
}
