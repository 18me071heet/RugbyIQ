package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateTeam;
import pageObject.DeleteTeam;
import pageObject.EditTeam;
import pageObject.LogIn;

public class DeleteTeamTest extends BaseClassRgy {

	@Test(priority=1,description="Delete Team")
	public void deleteTeam() throws InterruptedException {
		
		  LogIn loginPage = new LogIn(driver);
	        loginPage.performLogin(getProperty("email"), getProperty("password"));
	        
	        // 2. Go to My Teams
	        CreateTeam createTeamPage = new CreateTeam(driver);
	        createTeamPage.navigateToMyTeams();

	        // 3. Edit Team "Pro30"
	        EditTeam editTeamPage = new EditTeam(driver);
	        
	        // click three dot on "Pro10" team
	        editTeamPage.clickThreeDots("JM Second");
	        Thread.sleep(3000);
	        DeleteTeam delete = new DeleteTeam(driver);
	        
	        delete.clickOnRemoveTeam();
	        delete.clickOnConfirmDeleteTeam();
	        Thread.sleep(3000);
	     
	        
	        delete.isTeamNotVisibleInListing("JM Second");
	        
	        
	        
	        
	        
	}
}
