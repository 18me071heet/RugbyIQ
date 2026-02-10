package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlan;
import pageObject.CreateTeam;
import pageObject.DeletePlan;
import pageObject.EditPlan;
import pageObject.LogIn;

public class DeletePlanTest extends BaseClassRgy{
	
	@Test(priority=1,description="Delete Team")
	public void deleteTeam() throws InterruptedException {
			
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));
     
        CreateTeam createTeamPage = new CreateTeam(driver);
        createTeamPage.navigateToMyTeams();
        
        CreatePlan planPage = new CreatePlan(driver);
        Thread.sleep(2000);
        planPage.selectTeam("Pro10");

       EditPlan plan  = new EditPlan(driver);
             
        plan.clickThreeDots("New Pre");
        
        DeletePlan delete = new DeletePlan(driver);
        
        delete.clickOnRemovePlan();
        Thread.sleep(3000);
        
        delete.clickRemove();
        
	}

}
