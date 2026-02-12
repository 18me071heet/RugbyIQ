package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateDrill;
import pageObject.CreatePlan;
import pageObject.CreateSession;
import pageObject.CreateTeam;
import pageObject.DrillPlay;
import pageObject.EditSessionDrill;
import pageObject.LogIn;

public class DrillPlayTest extends BaseClassRgy {

	
	//@Test(priority=1,description="Drill Play and Stop")
	/*public void drillPlayStop() throws InterruptedException {
		
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
       
       DrillPlay play = new DrillPlay(driver);
       play.verifySessionDrillVideoPlay();
       
       Thread.sleep(5000);
 
       
	}*/
	
	
	@Test(priority=1,description="Drill Play and Stop in Detailing Page")
	public void drillDetailPage() throws InterruptedException {
		
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
       edit.clickOnSessionDrill("My Video");
       Thread.sleep(3000);
       
       edit.playAndStopVideo();
	}
}
