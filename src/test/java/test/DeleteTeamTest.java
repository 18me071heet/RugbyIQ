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
	        
	        CreateTeam createTeamPage = new CreateTeam(driver);
	        createTeamPage.navigateToMyTeams();

	        EditTeam editTeamPage = new EditTeam(driver);
	        
	        editTeamPage.clickThreeDots("JM Second");
	        Thread.sleep(3000);
	        DeleteTeam delete = new DeleteTeam(driver);
	        
	        delete.clickOnRemoveTeam();
	        delete.clickOnConfirmDeleteTeam();
	        Thread.sleep(3000);
	        
	        delete.isTeamNotVisibleInListing("JM Second");
	              
	}
}
