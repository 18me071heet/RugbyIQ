package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePlays {

	 WebDriver driver;
     WebDriverWait wait;
   
	   public CreatePlays(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	   
	   @FindBy(xpath="//button[@id='create_my_play_btn']")
	   WebElement btnCreateMyPlay;
	   
	   @FindBy(xpath=" //input[@id='play_name']")
	   WebElement txtPlayName;
	   
	   @FindBy(xpath="//button[normalize-space()='Create']")
	   WebElement btnSave;
	   
	   @FindBy(xpath = "//h2[contains(@class, 'text-gray-900')]")
	    List<WebElement> myPlaysListing;
	   
	   public void selectPlayBook(String playBookName) {
		    String xpath = "//h3[normalize-space()='" + playBookName + "']/ancestor::div[contains(@class,'bg-primary-100')]/a";
		    WebElement playBook = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		    playBook.click();
		    System.out.println("Selected playbook: " + playBookName);
		}
	   
	   public void clickCreate() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnCreateMyPlay)).click();
	   }
	   
	   public void enterPlayName(String playName) {
		   
		   wait.until(ExpectedConditions.visibilityOf(txtPlayName)).sendKeys(playName);
	   }
	   
	   public void savePlay() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnSave)).click();
	   }
	   
	   public boolean isMyPlaysVisible(String planName) {
		      
	        try { Thread.sleep(3000); } catch (InterruptedException e) {}
	        
	        for (WebElement element : myPlaysListing) {
	            String text = element.getText().trim();
	            if (text.equalsIgnoreCase(planName)) {
	                return true;
	            }
	        }
	        
	        return false;
	    }
	   
	   
	   
	   
}
