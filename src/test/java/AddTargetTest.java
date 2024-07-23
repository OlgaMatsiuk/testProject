import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTargetTest extends TestBase{
    int randomNumber = (int)(System.currentTimeMillis()/1000)%360;
    String targetName = "Virus Total Olga Test- "+randomNumber;
    TargetsPage targetsPage;
    String targetType="Virus Total Web API";
    String newTargetGroupName="Virus Total Olga Group- "+randomNumber;
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
        targetsPage.typeTargetName(targetName);
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
    public void wrongAPIKeyTest(){
        targetsPage.confirmAPIKey(APIKey+"5");
        targetsPage.clickSaveButton();
        Assert.assertEquals(targetsPage.getTextDanger(), "Password & Confirm Password does not match.");
    }
    @Test(priority =75)
    public void typeConfirmAPIKey(){
        targetsPage.confirmAPIKey(APIKey);
    }
    @Test(priority = 80)
    public void saveBtnAction(){
        targetsPage.clickSaveButton();
    }
    @Test(priority =90)
    public void typeInSearchTarget(){
        targetsPage.typeSearchTarget(targetName);
        targetsPage.isTargetPresent(targetName);
    }
    @Test(priority =100)
    public void typeInSearchGroup(){
        clickToTargetsBtn();
        targetsPage.typeSearchGroup(newTargetGroupName);
        targetsPage.isGroupPresent(newTargetGroupName);
    }

}
