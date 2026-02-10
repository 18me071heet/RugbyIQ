package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreatePlayBook;
import pageObject.LogIn;

public class CreatePlayBookTest extends BaseClassRgy {
	
	@Test(priority=1,description="Creation of Play Book")
	public void createPlayBook() {
		
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));
        
        CreatePlayBook create = new CreatePlayBook(driver);
        create.clickPlayBookOption();
        
        create.clickCreate();
        
        create.enterPlayBookName(getProperty("playBookName"));
        
        create.savePlayBook();
        
        create.isPlayBookVisible(getProperty("playBookName"));
        
	}

}
