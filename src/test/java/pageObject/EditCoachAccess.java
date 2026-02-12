package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCoachAccess {

	  WebDriver driver;
	    WebDriverWait wait;
	    
	    public EditCoachAccess(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	  }
	    
	    public void clickTeamByName(WebDriver driver, String teamName) {
	         
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[contains(@class,'bg-primary-100')]//h2") ));

	        for (WebElement team : driver.findElements(By.xpath("//div[contains(@class,'bg-primary-100')]//h2"))) {
	           
	            if (team.getText().trim().equalsIgnoreCase(teamName)) {
	             
	                WebElement teamLink = team.findElement(
	                    By.xpath("./ancestor::div[contains(@class,'bg-primary-100')]//a") );
	                wait.until(ExpectedConditions.elementToBeClickable(teamLink));
	                teamLink.click();
	                break;
	            }
	        }
	    }
	    
	    @FindBy(xpath="//button[normalize-space()='Yes, Change Role']")
	    WebElement changeRole;
	    
	    public void editRole() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(changeRole)).click();
	    }
}
