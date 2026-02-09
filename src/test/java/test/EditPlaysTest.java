package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlayBook;
import pageObject.CreatePlays;
import pageObject.EditPlays;
import pageObject.LogIn;

public class EditPlaysTest extends BaseClassRgy{

	@Test(priority=1,description="Edit Plays")
	public void editPlays() throws InterruptedException {
		
		 // 1. Login
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));

        CreatePlayBook create = new CreatePlayBook(driver);
        create.clickPlayBookOption();
        
		CreatePlays plays = new CreatePlays(driver);
		
		plays.selectPlayBook(getProperty("editedPlayBook"));
		
		EditPlays edit = new EditPlays(driver);
		
		Thread.sleep(3000);
		edit.clickThreeDot(getProperty("myPlays"));
		
		Thread.sleep(3000);
		edit.clickEditPlay(getProperty("myPlays"));
		
		Thread.sleep(3000);
		edit.editPlayName("My Pre Plays");
		
		Thread.sleep(3000);
		edit.clickUpdates();
	
		
	}
}
