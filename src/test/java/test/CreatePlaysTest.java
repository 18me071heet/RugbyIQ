package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlayBook;
import pageObject.CreatePlays;
import pageObject.LogIn;

public class CreatePlaysTest extends BaseClassRgy{

	@Test(priority=1,description="Create My Plays")
	public void createMyPlays() {
		
		 // 1. Login
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));

        CreatePlayBook create = new CreatePlayBook(driver);
        create.clickPlayBookOption();
        
		CreatePlays plays = new CreatePlays(driver);
		
		plays.selectPlayBook(getProperty("playBookName"));
		plays.clickCreate();
		
		plays.enterPlayName(getProperty("myPlays"));
		
		plays.savePlay();
		
		plays.isMyPlaysVisible(getProperty("myPlays"));
		
	}
}
