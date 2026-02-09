package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClassRgy;
import pageObject.LogIn;
import pageObject.CreateTeam;
import pageObject.EditTeam;

public class EditTeamTest extends BaseClassRgy {

    @Test(priority = 1, description = "Verify successful team editing")
    public void verifyEditTeam() throws InterruptedException {
        System.out.println("=== Test: Verify Successful Team Editing ===");

        // 1. Login
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));

        // 2. Go to My Teams
        CreateTeam createTeamPage = new CreateTeam(driver);
        createTeamPage.navigateToMyTeams();

        // 3. Edit Team "Pro30"
        EditTeam editTeamPage = new EditTeam(driver);
        
        // click three dot on "Pro30" team
        editTeamPage.clickThreeDots("Pro10");
        
        // click on edit
        editTeamPage.clickEdit();
        
        // edit the team name to Pro10
        editTeamPage.editTeamName("Pro10");
        
        Thread.sleep(4000);
        editTeamPage.clickDeleteIcon();
        
        Thread.sleep(4000);
        editTeamPage.uploadTeamLogo("C:\\Users\\INX\\Downloads\\rugby.jpg");
        
        // click on update
        Thread.sleep(4000);
        editTeamPage.clickUpdate();

        Thread.sleep(3000); // Wait for update to reflect

        // 4. Verify that edited name appears on the team listing page
        boolean isEditedNameVisible = createTeamPage.isTeamVisibleInListing("Pro10");
        Assert.assertTrue(isEditedNameVisible, "Edited team name 'Pro10' should be visible in the listing.");

        System.out.println("Team edit successful and verified!");
    }
}
