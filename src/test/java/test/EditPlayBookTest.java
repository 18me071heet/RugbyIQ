package test;

import org.testng.annotations.Test;
import baseClass.BaseClassRgy;
import pageObject.CreatePlayBook;
import pageObject.EditPlayBook;
import pageObject.LogIn;

public class EditPlayBookTest extends BaseClassRgy {

	@Test(priority=1,description="Edit Play Book")
	public void editPlayBookDetail() throws InterruptedException
	{
	
	    LogIn loginPage = new LogIn(driver);
	    loginPage.performLogin(getProperty("email"), getProperty("password"));
	    
	    CreatePlayBook create = new CreatePlayBook(driver);
	    create.clickPlayBookOption();
	    
	    EditPlayBook edit = new EditPlayBook(driver);
	   edit.clickThreeDot(getProperty("playBookName"));
	    Thread.sleep(4000);
	    
	    edit.clickEditOption(getProperty("playBookName"));
	    Thread.sleep(4000);
	    
	    edit.editPlaybookName("Pre Rugby");
	 
	    edit.clickUpdate();
	    
	    create.isPlayBookVisible("Pre Rugby");

	    
	}
	
}
