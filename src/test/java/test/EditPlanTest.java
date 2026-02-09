package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlan;
import pageObject.CreateTeam;
import pageObject.EditPlan;
import pageObject.LogIn;

public class EditPlanTest extends BaseClassRgy {

	@Test(priority=1,description="Update the specific plan")
	public void updatePlan() throws InterruptedException {
		
		 // 1. Login
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));

        // 2. Go to My Teams
        CreateTeam createTeamPage = new CreateTeam(driver);
        createTeamPage.navigateToMyTeams();
        
        // 3. Select Pro10 team
        CreatePlan planPage = new CreatePlan(driver);
        Thread.sleep(2000);
        planPage.selectTeam("Pro10");
        
        EditPlan editPlan = new EditPlan(driver);
        Thread.sleep(2000);
        editPlan.clickThreeDots("Pre Rugby Plan");
        Thread.sleep(2000);
        
        editPlan.clickEdit();
        Thread.sleep(2000);
        editPlan.editPlanName("Pre Rugby Plan");
        
        Thread.sleep(3000);
        editPlan.clickDeleteIcon();
        
        Thread.sleep(4000);
        editPlan.uploadPlanLogo("C:\\Users\\INX\\Downloads\\new rgy.jpg");
          
        Thread.sleep(2000);
        editPlan.clickUpdate();
        
        CreatePlan create = new CreatePlan(driver);
        boolean isEditedNameVisible = create.isPlanVisible("Pre Rugby Plan");
        Assert.assertTrue(isEditedNameVisible, "Edited plan name 'Pre Rugby Plan' should be visible in the listing.");
	}
}
