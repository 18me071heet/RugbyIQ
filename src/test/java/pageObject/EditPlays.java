package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPlays {

	 WebDriver driver;
	    WebDriverWait wait;

	    public EditPlays(WebDriver driver) {
	    	
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath=" //button[normalize-space()='Update']")
	    WebElement clickUpdate;
	    
	    @FindBy(id = "play_name")
	    public WebElement playNameInput;
	
	    
	    public void clickThreeDot(String plays) {
	        String xpath = "//h3[normalize-space()='" + plays + "']/ancestor::div[contains(@class,'bg-primary-100')]//button[contains(@id,'dropdownDefaultButton')]";
	        WebElement threeDot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        threeDot.click();
	        System.out.println("Clicked three-dot menu for: " + plays);
	    }
	    
	    public void clickEditPlay(String playName) {

	        String xpath = "//h3[normalize-space()='" + playName + "']/ancestor::div[contains(@class,'bg-primary-100')]//a[contains(@class,'edit_myplay')]";

	        WebElement editBtn = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	        wait.until(ExpectedConditions.elementToBeClickable(editBtn));

	        editBtn.click();

	        System.out.println("Clicked Edit for play: " + playName);
	    }
	    
	    public void editPlayName(String newPlayName) {
	        wait.until(ExpectedConditions.visibilityOf(playNameInput));
	        playNameInput.clear();
	        playNameInput.sendKeys(newPlayName);
	    }
	    
	    public void clickUpdates() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(clickUpdate)).click();
	    }
	    
}
