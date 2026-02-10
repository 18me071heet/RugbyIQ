package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateMyDrill;
import pageObject.EditMyDrill;
import pageObject.LogIn;

public class EditMyDrillTest extends BaseClassRgy {
	
	@Test(priority=1,description= "Edit My Drill")
	public void editDrill() throws InterruptedException {
		
       LogIn loginPage = new LogIn(driver);
       loginPage.performLogin(getProperty("email"), getProperty("password"));
        
       CreateMyDrill drill = new CreateMyDrill(driver);
       drill.clickMyDrillOption();
       Thread.sleep(3000);
       
       drill.clickOnMyDrill(getProperty("myDrillName"));
       
       EditMyDrill editDrill = new EditMyDrill(driver);
       editDrill.editDrillClick();
       
       editDrill.editMyDrillName(getProperty("editMyDrillName"));
       
       editDrill.editUrl(getProperty("editDrillURL"));
       
       editDrill.editNotes(getProperty("editDrillNotes"));
       
       editDrill.updateDrill();
       
       drill.isMyDrillVisible(getProperty("editMyDrillName"));
     
	}

}
