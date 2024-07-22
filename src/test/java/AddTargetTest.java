import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTargetTest extends TestBase{
    TargetsPage targetsPage;
    String targetType="Virus Total Web API";
    String newTargetGroupName="Virus Total Olga";
    String APIKey="12345";
    @BeforeClass
    public void precondition(){
        login();
        targetsPage = app.getTargetsPage();
    }

    @Test(priority =10)
    public void clickToTargetsBtn(){
        targetsPage.clickTargetsBtnInDashboard();
    }
    @Test(priority =20)
    public void clickAddBtnInTargets(){
        targetsPage.clickAddButton();
    }
    @Test(priority =30)
    public void typeTargetNameInForm(){
        targetsPage.typeTargetName("Virus Total Olga Test");
    }
    @Test(priority =40)
    public void typeTargetTypeInForm(){
        targetsPage.getTargetTypeOption(targetType);
    }
    @Test(priority =50)
    public void addTargetGroup(){
        targetsPage.clickAddNewTargetGroupBtn();
        targetsPage.fillFormNewTargetGroup(newTargetGroupName);

    }
    @Test(priority =60)
    public void typeAPIKeyAction(){
        targetsPage.typeAPIKey(APIKey);
    }
    @Test(priority =70)
    public void confirmAPIKeyAction(){
        targetsPage.confirmAPIKey(APIKey);
    }
    @Test(priority = 80)
    public void saveBtnAction(){
        targetsPage.clickSaveButton();
    }
}
