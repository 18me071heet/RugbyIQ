package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InviteCoach {

	   WebDriver driver;
	    WebDriverWait wait;
	    
	    public InviteCoach(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath="//button[@id='invite_coach_create_btn']")
	    WebElement clickInvite;
	    
	    @FindBy(xpath=" //input[@placeholder='Name']")
	    WebElement nameCoach;
	    
	    @FindBy(xpath=" //input[@placeholder='Email']")
	    WebElement emailCoach;
	    
	    @FindBy(xpath=" //button[normalize-space()='Invite']")
	    WebElement btnInvite;
	    
	    @FindBy(xpath="//a[@id='add-more']")
	    WebElement linkAddMore;
	    
	    @FindBy(name = "invited_coaches[1][name]")
	    private WebElement coachNameInput1;
	    
	    @FindBy(name = "invited_coaches[1][email]")
	    private WebElement coachEmailInput1;
	    
	    public void inviteCoach() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(clickInvite)).click();
	    }
	    
	    public void coachName(String name) {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(nameCoach)).sendKeys(name);
	    }
	    
	    public void coachEmail(String email) {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(emailCoach)).sendKeys(email);
	    }
	    
	   public void clickInviteCoach() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnInvite)).click();
	   }
	   
	   public void clickAddMore() {
		   
		   wait.until(ExpectedConditions.visibilityOf(linkAddMore)).click();
	   }
	   
	   public void entersecondCoachName(String secondName) {
		   
		   wait.until(ExpectedConditions.visibilityOf(coachNameInput1)).sendKeys(secondName);
	   }
	   
	   public void entersecondCoachEmail(String secondEmail) {
		   
		   wait.until(ExpectedConditions.visibilityOf(coachEmailInput1)).sendKeys(secondEmail);
		   
	   }
	    
	    
	    
}
