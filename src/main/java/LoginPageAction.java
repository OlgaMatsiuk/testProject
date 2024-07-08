import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPageAction extends HelperBase{

    public LoginPageAction(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(how = How.ID, using = "loginBtn")
    public WebElement loginBtn;

    @FindBy(how = How.ID, using = "username")
    public WebElement userNameInput;

    @FindBy(how = How.ID, using ="password")
    public WebElement userPasswordInput;


    public void fillLoginForm(String name, String password) {
        type(userNameInput, name);
        type(userPasswordInput,password);
    }

    public void clickLoginButton(){
        click(loginBtn);
    }

    public void login(String name, String password){
        fillLoginForm(name, password);
        clickLoginButton();
    }

}
