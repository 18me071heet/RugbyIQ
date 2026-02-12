package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditSessionName {

	 WebDriver driver;
	    WebDriverWait wait;

	    public EditSessionName(WebDriver driver) {
	    	
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath=" //button[normalize-space()='Update']")
	    WebElement updateSession;
	    
	    @FindBy(css = "input[name='name']")
	    WebElement txtSessionName;
	    
	
	public void clickEditSessionByName(String sessionName) {

	    By editBtn = By.xpath("//h2[normalize-space()='" + sessionName + "']//a[contains(@class,'edit_session')]");

	    WebElement editIcon = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(editBtn));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", editIcon);

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
	    } catch (Exception e) {
	        System.out.println("Normal click failed, using JS click");
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
	    }

	    System.out.println("Clicked edit icon for session: " + sessionName);
	}
	
	public void editSessionName(String newName) {

	    wait.until(ExpectedConditions.visibilityOf(txtSessionName));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", txtSessionName);

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(txtSessionName)).click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txtSessionName);
	    }

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].value='';", txtSessionName);

	    txtSessionName.sendKeys(newName);

	    System.out.println("Session name updated to: " + newName);
	}
	
	public void clickUpdate() {
		
		wait.until(ExpectedConditions.visibilityOf(updateSession)).click();
		
	}

}
