package Base;

import Pages.LoginPage;
import Pages.TaskListPage;
import Pages.TargetsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
    public WebDriver wd;
    public LoginPage user;
    public TaskListPage taskList;
    public TargetsPage targetsPage;


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

    public LoginPage getLoginPage() {
        user = new LoginPage(wd);
        return user;
    }

    public TaskListPage getTaskListPage() {
        taskList = new TaskListPage(wd);
        return taskList;
    }

}
