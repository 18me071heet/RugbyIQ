package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.InviteCoach;
import pageObject.LogIn;
import pageObject.Navigations;

public class InviteCoachTest extends BaseClassRgy {
	
	@Test
	public void inviteCoach() throws InterruptedException {
		
		
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));
        
        Navigations navigation = new Navigations(driver);
        
        navigation.clickInviteCoaches();
        
        InviteCoach coach = new InviteCoach(driver);
        
        coach.inviteCoach();
        
        Select selectTeam = new Select(driver.findElement(By.xpath("//select[@id='team_id']")));
        Thread.sleep(3000);
        selectTeam.selectByVisibleText("Pro10");
        
        coach.coachName(getProperty("coachName"));
        Thread.sleep(3000);
        coach.coachEmail(getProperty("coachEmail"));
        
        Select selectAccess = new Select(driver.findElement(By.xpath("//select[@name='invited_coaches[0][role]']")));
        Thread.sleep(3000);
        selectAccess.selectByVisibleText("Full Access");
        
        coach.clickAddMore();
        
        coach.entersecondCoachName(getProperty("secondCoachName"));
        coach.entersecondCoachEmail(getProperty("secondCoachEmail"));
        
        Select select = new Select(driver.findElement(By.xpath("//select[@name='invited_coaches[1][role]']")));
        select.selectByVisibleText("Add Video Only");
        
        Thread.sleep(3000);
        coach.clickInviteCoach();
                
        
	}

}
