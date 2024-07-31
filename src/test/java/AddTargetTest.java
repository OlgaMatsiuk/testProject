import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddTargetTest extends TestBase{
    int randomNumber = (int)(System.currentTimeMillis()/1000)%360;
    String targetName = "Virus Total Olga Test- "+randomNumber;
    String taskName = "-" + randomNumber;
    public TargetsPage targetsPage;
    public TaskListPage taskListPage;
    public AddTaskPageSection addTaskPageSection;
    public AddTargetsSection addTargetsSection;
    String targetType="Virus Total Web API";
    String newTargetGroupName="Virus Total Olga Group- "+randomNumber;
    String APIKey="12345";
    @BeforeClass
    public void precondition(){
        login();
        targetsPage = app.getTargetsPage();
        taskListPage = app.getTaskListPage();
        addTargetsSection = targetsPage.getAddTargetsSection();
        addTaskPageSection = taskListPage.getAddTaskPageSection();
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
        addTargetsSection.typeTargetName(targetName);
    }
    @Test(priority =40)
    public void typeTargetTypeInForm(){
        addTargetsSection.getTargetTypeOption(targetType);
    }
    @Test(priority =50)
    public void addTargetGroup(){
        addTargetsSection.clickAddNewTargetGroupBtn();
        addTargetsSection.fillFormNewTargetGroup(newTargetGroupName);
    }
    @Test(priority =60)
    public void typeAPIKeyAction(){
        addTargetsSection.typeAPIKey(APIKey);
    }
    @Test(priority =70)
    public void wrongAPIKeyTest(){
        addTargetsSection.confirmAPIKey(APIKey+"5");
        addTargetsSection.clickSaveButton();
        Assert.assertEquals(targetsPage.getTextDanger(), "Password & Confirm Password does not match.");
    }
    @Test(priority =75)
    public void typeConfirmAPIKey(){
        addTargetsSection.confirmAPIKey(APIKey);
    }
    @Test(priority = 80)
    public void saveBtnAction(){
        addTargetsSection.clickSaveButton();
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
    @Test(priority =110)
    public void newTaskAfterTargets(){
        taskListPage.clickTaskListBtnInDashboard();
        taskListPage.clickAddTaskButton();
        addTaskPageSection.inputNewTaskName(taskName);
    }
    @Test(priority =115)
    public void searchTargetTypeInTasks(){
        addTaskPageSection.searchInSidebar(targetType);
        addTaskPageSection.dragAndDropAction();
        addTaskPageSection.searchTargetsInRightSidebarInTaskList(targetName);
    }
    @Test(priority =120)
    public void targetsSingleTest(){
        Assert.assertTrue(addTaskPageSection.isTargetsOptionPresent());
    }
    @Test(priority =122)
    public void parametersLoopForOfTestInAction(){
        addTaskPageSection.setParametersLoopFor("2");
        addTaskPageSection.setParametersLoopOf("");
    }

    @Test(priority =130)
    public void dragAndDropSecondTask(){
        addTaskPageSection.dragAndDropActionSecond();
        addTaskPageSection.clickByRadioBtnTargetsGroup();
        addTaskPageSection.searchTargetsInRightSidebarInTaskList(newTargetGroupName);
    }
    @Test(priority =142)
    public void parametersLoopForOfTestInActionSecond(){
        addTaskPageSection.setParametersLoopFor("1");
        addTaskPageSection.setParametersLoopOf("");
    }
    @Test(priority =150)
    public void saveTarget(){
        addTaskPageSection.clickOfSaveButton();
    }

}
