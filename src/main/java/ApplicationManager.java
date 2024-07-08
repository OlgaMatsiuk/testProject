import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
    WebDriver wd;
    LoginPageAction user;

    TaskListPageAction taskList;

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.navigate().to("https://testing.cloud.cyberm8.com/");
        wd.manage().window().maximize();
        user = new LoginPageAction(wd);
        taskList = new TaskListPageAction(wd);
    }

    public void tearDown() {
        wd.quit();
    }

    public LoginPageAction getUser() {
        return user;
    }

    public TaskListPageAction getTaskList() {
        return taskList;
    }

}
