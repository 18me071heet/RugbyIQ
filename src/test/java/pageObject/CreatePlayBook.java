package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePlayBook {
	

      WebDriver driver;
      WebDriverWait wait;
    
	   public CreatePlayBook(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	   
	   @FindBy(xpath="//span[normalize-space()='Playbook']")
	   WebElement playBookOption;
	   
	   @FindBy(xpath=" //button[@id='create_playbook']")
	   WebElement btnCreate;
	   
	   @FindBy(xpath=" //input[@id='playbook_name']")
	   WebElement txtPlaybookName;
	   
	   @FindBy(xpath="//button[@id='submit_btn']")
	   WebElement btnSave;
	   
	   @FindBy(xpath = "//h2[contains(@class, 'text-gray-900')]")
	    List<WebElement> playBookListing;
	   
	   public void clickPlayBookOption() {
		   
		   wait.until(ExpectedConditions.visibilityOf(playBookOption)).click();
	   }
	   
	   public void clickCreate() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnCreate)).click();
	   }
	   
	   public void enterPlayBookName(String playBookName) {
		   
		   wait.until(ExpectedConditions.visibilityOf(txtPlaybookName)).sendKeys(playBookName);
	   }
	   
	   public void savePlayBook() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnSave)).click();
		   
	   }
	   
	   public boolean isPlayBookVisible(String planName) {
		      
	        try { Thread.sleep(3000); } catch (InterruptedException e) {}
	        
	        for (WebElement element : playBookListing) {
	            String text = element.getText().trim();
	            if (text.equalsIgnoreCase(planName)) {
	                return true;
	            }
	        }
	        
	        return false;
	    }
	   
	   
	   
	   
}
