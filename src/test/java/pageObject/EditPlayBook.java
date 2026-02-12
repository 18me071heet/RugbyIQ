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

public class EditPlayBook {

	  WebDriver driver;
	    WebDriverWait wait;

	    public EditPlayBook(WebDriver driver) {
	    	
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(id = "submit_btn")
	    public WebElement updateButton;
	    
	    @FindBy(id = "playbook_name")
	    public WebElement playbookNameInput;
	    
	    @FindBy(xpath = "//h2[contains(@class,'text-gray-900')]")
	    List<WebElement> playBookListing;
	    
	    public void clickThreeDot(String playBookName) {
	        String xpath = "//h3[normalize-space()='" + playBookName + "']/ancestor::div[contains(@class,'bg-primary-100')]//button[contains(@id,'dropdownDefaultButton')]";
	        WebElement threeDot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        threeDot.click();
	        System.out.println("Clicked three-dot menu for: " + playBookName);
	    }
	    
	    public void clickEditOption(String playBookName) {
	        String xpath = "//h3[normalize-space()='" + playBookName + "']/ancestor::div[contains(@class,'bg-primary-100')]//a[contains(@class,'edit_playbook') and normalize-space()='Edit']";
	        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        editBtn.click();
	        System.out.println("Clicked Edit for playbook: " + playBookName);
	    }
	    
	    public void editPlaybookName(String newName) {
	        wait.until(ExpectedConditions.visibilityOf(playbookNameInput));
	        playbookNameInput.clear();
	        playbookNameInput.sendKeys(newName);
	    }
	    
	    public void clickUpdate() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(updateButton)).click();
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
