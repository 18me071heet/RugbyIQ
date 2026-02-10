package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlayBook;
import pageObject.CreatePlays;
import pageObject.EditPlays;
import pageObject.LogIn;

public class CreatePlaysTest extends BaseClassRgy{

	//@Test(priority=1,description="Create My Plays")
	/*public void createMyPlays() {
		
		
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
	*/
	
	@Test(priority=2,description="Delete Play")
	public void deletePlay() throws InterruptedException {
		
		 LogIn loginPage = new LogIn(driver);
	        loginPage.performLogin(getProperty("email"), getProperty("password"));

	        CreatePlayBook create = new CreatePlayBook(driver);
	        create.clickPlayBookOption();
	        
			CreatePlays plays = new CreatePlays(driver);
			
			plays.selectPlayBook(getProperty("playBookName"));
			Thread.sleep(3000);
			EditPlays edit = new EditPlays(driver);
			
			Thread.sleep(3000);
			edit.clickThreeDot(getProperty("deleteMyPlays"));
			
			
	        plays.clickOnDeletePlay();
	        Thread.sleep(3000);
	        plays.removePlays();
			
			
	}
}
