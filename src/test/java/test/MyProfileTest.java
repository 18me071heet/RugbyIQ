package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.LogIn;
import pageObject.MyProfile;

public class MyProfileTest extends BaseClassRgy {

	@Test(priority=1,description="Edit Profile Details")
	public void editProfile() throws InterruptedException {
		
		 LogIn loginPage = new LogIn(driver);
	     loginPage.performLogin(getProperty("email"), getProperty("password"));
	     
	     MyProfile profile = new MyProfile(driver);
	     profile.clickProfileIcon();
	     Thread.sleep(2000);
	     profile.clickSettings();
	     
	     profile.editFname(getProperty("editFname"));
	     profile.editLname(getProperty("editLname"));
	     
	     Select select = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
	     Thread.sleep(2000);
	     select.selectByVisibleText("Australia");
	     
	     Thread.sleep(2000);
	     profile.clickUpdate();
	     
	     
	     
	     
	}
}
