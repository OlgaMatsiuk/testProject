import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {

    WebDriver wd;
    LoginPageAction user;

    TaskListPageAction taskList;

    AddTaskPageSection addTaskPageSection;

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        //wd = new ChromeDriver();
        wd.navigate().to("https://testing.cloud.cyberm8.com/");
       // wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        user = new LoginPageAction(wd);
        taskList = new TaskListPageAction(wd);
        addTaskPageSection = new AddTaskPageSection(wd);

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

    public AddTaskPageSection getAddTaskPageSection() {
        return addTaskPageSection;
    }
}
