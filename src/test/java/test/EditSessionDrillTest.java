package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateDrill;
import pageObject.CreatePlan;
import pageObject.CreateSession;
import pageObject.CreateTeam;
import pageObject.EditSessionDrill;
import pageObject.LogIn;

public class EditSessionDrillTest extends BaseClassRgy{

	@Test(priority=1,description="Edit the Specific Session Drill")
	public void editSessionDrill() throws InterruptedException {
		
		 // 1. Login
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));
        
        // 2. Navigate to My Teams
        CreateTeam teamPage = new CreateTeam(driver);
        teamPage.navigateToMyTeams();
        
        // 3. Select Pro30 team
        CreatePlan planPage = new CreatePlan(driver);
        planPage.selectTeam("Pro10");
        
        // 4. Select Pre plan
       CreateSession sessionPage = new CreateSession(driver);
       sessionPage.selectPlan("Pre Rugby Plan");
  
       CreateDrill drill =  new CreateDrill(driver);
       //5. Select Pre Session
       drill.selectSession("Pre Rugby Session");
       
       EditSessionDrill edit = new EditSessionDrill(driver);
       edit.clickOnSessionDrill("Pre Session Rugby Drill");
       Thread.sleep(3000);
       
       edit.clickEditDrill();
       Thread.sleep(2000);
       edit.editDrillName("Pre Session Rugby Drill");
       
       edit.clickUpdateDrill();
       
       
	}
}
