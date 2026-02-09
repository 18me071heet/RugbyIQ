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

public class EditSessionDrill {

	 WebDriver driver;
	    WebDriverWait wait;

	    public EditSessionDrill(WebDriver driver) {
	    	
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath=" //button[normalize-space()='Edit Drill']")
	    WebElement editDrill;
	    
	    @FindBy(xpath = "//input[@placeholder='Enter drill name']")
	    WebElement editDrillNameInput;
	    
	    @FindBy(xpath="//button[normalize-space()='Update']")
	    WebElement updateDrill;
	    
	    
	    public void clickOnSessionDrill(String drillName) {

	        String xpath = "//h3[normalize-space()='" + drillName + "']/ancestor::a";

	        WebElement drill = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", drill);

	        try {
	            drill.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drill);
	        }

	        System.out.println("Clicked on drill: " + drillName);
	    }

	    
	    public void clickEditDrill() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(editDrill)).click();
	    
	    }
	    
	    
	    public void editDrillName(String drillName) {
	        editDrillNameInput.clear();
	        editDrillNameInput.sendKeys(drillName);
	    }
	    
	    public void clickUpdateDrill() {
	    	
	    	updateDrill.click();
	    }
}
