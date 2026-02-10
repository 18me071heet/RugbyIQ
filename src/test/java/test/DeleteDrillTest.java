package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateDrill;
import pageObject.CreatePlan;
import pageObject.CreateSession;
import pageObject.CreateTeam;
import pageObject.DeleteDrill;
import pageObject.LogIn;

public class DeleteDrillTest extends BaseClassRgy{

	@Test(priority=1,description="Delete Drill")
	public void deleteDrill() throws InterruptedException {
		
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
       
       DeleteDrill delete = new DeleteDrill(driver);
       Thread.sleep(3000);
       delete.clickOnThreeDotByName("My Video");
       Thread.sleep(3000);
       
       delete.clickDeleteDrillOption("My Video");
       Thread.sleep(3000);
       
       delete.removeDrill();
       
       Thread.sleep(2000);
       
       
       
	}
}
