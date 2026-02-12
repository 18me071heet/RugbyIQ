package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {

	WebDriver driver;
	WebDriverWait wait;
	
    public SignUp(WebDriver driver) {
    	
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath=" //input[@placeholder='Enter first name']")
    WebElement txtFname;
    
    @FindBy(xpath=" //input[@placeholder='Enter last name']")
    WebElement txtLname;
    
    @FindBy(xpath=" //input[@placeholder='Enter email']")
    WebElement txtEmail;
    
    @FindBy(xpath="//input[@placeholder='Enter team name']")
    WebElement txtTeam;
    
    @FindBy(xpath=" //input[@id='password']")
    WebElement txtPassword;
    
    @FindBy(xpath=" //input[@id='c_password']")
    WebElement txtCpass;
    
    @FindBy(xpath=" //input[@id='remember']")
    WebElement checkPrivacy;
    
    @FindBy(xpath="//button[normalize-space()='Sign Up']")
    WebElement signUp;

    @FindBy(xpath="//input[@id='dob']")
    WebElement txtDob;

    @FindBy(xpath="//*[contains(@class,'invalid') or contains(@class,'error') or contains(text(),'required') or contains(text(),'Required')]")
    java.util.List<WebElement> errorMessages;
    
    
    public void enterFname(String fname) {
        wait.until(ExpectedConditions.visibilityOf(txtFname)).sendKeys(fname);
    
    }
    
    public void enterLname(String lname) {
    	
    	wait.until(ExpectedConditions.visibilityOf(txtLname)).sendKeys(lname);
    }
    
   public void enterPass(String pass) {
    	
    	wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(pass);
    }


   public void enterCpass(String cpass) {
	
	wait.until(ExpectedConditions.visibilityOf(txtCpass)).sendKeys(cpass);
	
   }
   
   public void enterTeam(String team) {
	   
	   wait.until(ExpectedConditions.visibilityOf(txtTeam)).sendKeys(team);
   }
   
   public void enterEmail(String email) {
	   
	   wait.until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);
   }
   
   public void selectCheckbox() {
       wait.until(ExpectedConditions.elementToBeClickable(checkPrivacy)).click();
       System.out.println("Selected terms and conditions.");
   }
   
   public void uploadProfileImage() {
  	 
  	     WebElement uploadImage = driver.findElement(By.xpath(" //input[@id='profile_image']"));
		 uploadImage.sendKeys("C:\\Users\\INX\\Downloads\\rugby.jpg");
	 
   }
   
   public void clickSignUp() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(signUp)).click();
   }

   public void enterDOB(String dob) {
       wait.until(ExpectedConditions.visibilityOf(txtDob)).sendKeys(dob);
   }
   
   public boolean areValidationMessagesDisplayed() {
       return !errorMessages.isEmpty() && errorMessages.stream().anyMatch(WebElement::isDisplayed);
   }
}
