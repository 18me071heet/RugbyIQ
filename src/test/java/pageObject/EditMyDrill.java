package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditMyDrill {

	 WebDriver driver;
     WebDriverWait wait;
   
	   public EditMyDrill(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	   
	   @FindBy(xpath="//button[normalize-space()='Edit Drill']")
	   WebElement btnEditDrill;
	 
	   @FindBy(xpath=" //input[@placeholder='Enter drill name']")
	   WebElement editDrillName;
	   
	   @FindBy(xpath=" //input[@placeholder='Enter video url']")
	   WebElement editVideoUrl;
	   
	   @FindBy(xpath="//textarea[@name='notes']")
	   WebElement txtEditNotes;
	   
	   @FindBy(xpath=" //button[normalize-space()='Update']")
	   WebElement btnUpdate;
	   
	   public void editDrillClick() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(btnEditDrill)).click();
	    	
	    }
	   
	   public void editMyDrillName(String newMyDrillName) {
		   
		   WebElement input = wait.until(ExpectedConditions.visibilityOf(editDrillName));
		    input.clear();
		    input.sendKeys(newMyDrillName);
	   }
	   
	   public void editUrl(String newUrl) {
		   
		 WebElement newUr=  wait.until(ExpectedConditions.visibilityOf(editVideoUrl));
		 newUr.clear();
		 newUr.sendKeys(newUrl);
	   }
	   
	   public void updateDrill() {
		   
		   wait.until(ExpectedConditions.visibilityOf(btnUpdate)).click();
	   }
	   
	   public void editNotes(String newNotes) {
		   
		   WebElement notes= wait.until(ExpectedConditions.visibilityOf(txtEditNotes));
		   notes.clear();
		   notes.sendKeys(newNotes);
		   
	   }
}
