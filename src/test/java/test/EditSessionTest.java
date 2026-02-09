package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateDrill;
import pageObject.CreatePlan;
import pageObject.CreateSession;
import pageObject.CreateTeam;
import pageObject.EditSessionName;
import pageObject.LogIn;

public class EditSessionTest extends BaseClassRgy{

	@Test(priority=1,description="Edit Session Details")
	public void editSession() throws InterruptedException {
		
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
        drill.selectSession("Pre Session");
        
        EditSessionName editSession = new EditSessionName(driver);
        Thread.sleep(3000);
        editSession.clickEditSessionByName("Pre Session");
        
        Thread.sleep(3000);
        editSession.editSessionName("Pre Rugby Session");
        editSession.clickUpdate();
    
	}
}
