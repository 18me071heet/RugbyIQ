package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile {

	WebDriver driver;
    WebDriverWait wait;
    
    public MyProfile(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath=" //a[normalize-space()='Settings']")
    WebElement btnSettings;
    
    @FindBy(xpath=" //input[@id='first_name']")
    WebElement txtFname;
    
    @FindBy(xpath=" //input[@id='last_name']")
    WebElement txtLname;
    
    @FindBy(xpath=" //button[normalize-space()='Update Profile']")
    WebElement btnUpdate;
    
    @FindBy(xpath = "//div[@id='dropdownDefaultButton']")
    WebElement userProfileDropdown;
    
    
    public void clickSettings() {
    	
    	wait.until(ExpectedConditions.visibilityOf(btnSettings)).click();
    }
    
    public void editFname(String fname) {
    	
    	WebElement edtFname = wait.until(ExpectedConditions.visibilityOf(txtFname));
    	edtFname.clear();
    	edtFname.sendKeys(fname);
    }
    
  public void editLname(String lname) {
    	
    	WebElement edtLname = wait.until(ExpectedConditions.visibilityOf(txtLname));
    	edtLname.clear();
    	edtLname.sendKeys(lname);
    }
  
  public void clickUpdate() {
	  
	  wait.until(ExpectedConditions.visibilityOf(btnUpdate)).click();
  }
  
  public void clickProfileIcon() {
	  
	  wait.until(ExpectedConditions.visibilityOf(userProfileDropdown)).click();
  }
    
    
    
    
}
