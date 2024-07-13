import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DetailsTaskPage extends HelperBase{
    public DetailsTaskPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public String saveNameTask(){
        return wd.findElement(By.xpath("//div[@class='task-title mr-1']")).getText();
    }

}
