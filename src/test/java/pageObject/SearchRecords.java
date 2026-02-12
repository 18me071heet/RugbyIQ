package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchRecords {

	 WebDriver driver;
     WebDriverWait wait;
   
	   public SearchRecords(WebDriver driver) {
		   
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	   
	   @FindBy(xpath=" //input[@id='default-search']")
	   WebElement txtSearchBox;
	   
	   @FindBy(xpath=" //button[normalize-space()='Search']")
	   WebElement btnSearch;
	   
	   public void searchRecordName(String name) {
		   
		   wait.until(ExpectedConditions.visibilityOf(txtSearchBox)).sendKeys(name);
	   }
	   
	   public void clickSearch() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
	   }
	   	   
}
