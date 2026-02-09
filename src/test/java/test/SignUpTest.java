package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.LogIn;
import pageObject.SignUp;

public class SignUpTest extends BaseClassRgy{

	@Test(priority=1,description="Verify Sign Up functionality with validation check")
	public void signUpFunctionality() throws InterruptedException {
		
		 LogIn loginPage = new LogIn(driver);
		 loginPage.clickSignUp();
		 
		 SignUp signUpPage = new SignUp(driver);

		 // Step 1: Click Sign Up without entering mandatory fields and verify validation
		 
		 signUpPage.clickSignUp();
		 Thread.sleep(1000);
		 
		 boolean isErrorDisplayed = signUpPage.areValidationMessagesDisplayed();
		 
		 if(isErrorDisplayed) {
			System.out.println("Validation messages are displayed as expected for empty fields.");
		 } else {
			System.err.println("Validation messages NOT displayed for empty fields.");
		 }
		 
		 Assert.assertTrue(isErrorDisplayed, "This field is required.");

		 // Step 2: Continue with the sign-up process by entering all required details
		 
		 signUpPage.enterFname(getProperty("fname"));
		 signUpPage.enterLname(getProperty("lname"));
		 signUpPage.enterEmail(getProperty("Signupemail"));
		 signUpPage.enterTeam(getProperty("team"));
		 signUpPage.enterPass(getProperty("pass"));
		 signUpPage.enterCpass(getProperty("cpass"));
		 signUpPage.enterDOB(getProperty("dob"));
		 
		 Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
		 selectCountry.selectByVisibleText("Australia");
		 
		 Select selectLevel = new Select(driver.findElement(By.xpath(" //select[@id='level']")));
		 selectLevel.selectByVisibleText("Beginner");
		 
		 signUpPage.uploadProfileImage();
		 
		 signUpPage.selectCheckbox();
		 
		 signUpPage.clickSignUp();
		 
		 Thread.sleep(4000);
	}
}
