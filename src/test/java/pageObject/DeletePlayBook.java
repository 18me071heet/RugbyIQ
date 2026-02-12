package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePlayBook {

	    WebDriver driver;
	    WebDriverWait wait;
	    
	    public DeletePlayBook(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath="//a[normalize-space()='Yes Remove']")
	    WebElement btnRemove;
	    
	    public void clickThreeDot(String playBookName) {
	        String xpath = "//h3[normalize-space()='" + playBookName + "']/ancestor::div[contains(@class,'bg-primary-100')]//button[contains(@id,'dropdownDefaultButton')]";
	        WebElement threeDot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        threeDot.click();
	        System.out.println("Clicked three-dot menu for: " + playBookName);
	    }
	    
	    public void clickDeleteOption(String playBookName) {
	        String xpath = "//h3[normalize-space()='" + playBookName + "']/ancestor::div[contains(@class,'bg-primary-100')]//a[contains(@class,'delete_playbook') and normalize-space()='Delete']";
	        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        editBtn.click();
	        System.out.println("Clicked Edit for playbook: " + playBookName);
	    }
	    
	    public void confirmRemove() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(btnRemove)).click();
	    	
	    }
}
