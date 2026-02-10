package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateMyDrill;
import pageObject.DeleteMyDrill;
import pageObject.LogIn;

public class DeleteMyDrillTest extends BaseClassRgy {

	@Test(priority=1,description="Delete My Drill")
	public void deleteMyDrill() throws InterruptedException {
		
		
	       LogIn loginPage = new LogIn(driver);
	       loginPage.performLogin(getProperty("email"), getProperty("password"));
	        
	       CreateMyDrill drill = new CreateMyDrill(driver);
	       drill.clickMyDrillOption();
	       Thread.sleep(3000);
	    
	       drill.clickOnThreeDotByDrillName(getProperty("myDrillName"));
	       
	       Thread.sleep(3000);
	       DeleteMyDrill delete = new DeleteMyDrill(driver);
	       delete.clickDeleteOption();
	       
	       Thread.sleep(3000);
	       delete.removeMyDrill();
	       
	       Thread.sleep(3000);
	       
	       
	}
}
