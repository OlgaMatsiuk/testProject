import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
    WebDriver wd;
    LoginPageAction user;
    TaskListPageAction taskList;
    TargetsPage targetsPage;

    public TargetsPage getTargetsPage() {
        targetsPage=new TargetsPage(wd);
        return targetsPage;
    }

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.navigate().to("https://testing.cloud.cyberm8.com/");
        wd.manage().window().maximize();
    }

    public void tearDown() {
        wd.quit();
    }

    public LoginPageAction getLoginPage() {
        user = new LoginPageAction(wd);
        return user;
    }

    public TaskListPageAction getTaskListPage() {
        taskList = new TaskListPageAction(wd);
        return taskList;
    }

}
