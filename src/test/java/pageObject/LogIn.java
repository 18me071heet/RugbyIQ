package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogIn {
    
    public WebDriver driver;
    public WebDriverWait wait;
    
    @FindBy(name = "email")
    public WebElement emailField;
    
    @FindBy(id = "password")
    public WebElement passwordField;
  
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Sign in')]")
    public WebElement loginButton;
    
    @FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
    public WebElement forgotPasswordLink;
    
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    public WebElement signUpLink;
    
    @FindBy(xpath = "//*[contains(@class,'error') or contains(@class,'alert') or contains(@class,'invalid')]")
    public WebElement errorMessage;
    
    public LogIn(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Entered email: " + email);
    }
    
  
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password.");
    }
    
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        System.out.println("Clicked on Login button.");
    }
    
    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    
  
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
 
    public boolean isLoginButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return loginButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    

    public boolean isEmailFieldDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailField));
            return emailField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
  
    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
    
  
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
        System.out.println("Clicked on Forgot Password link.");
    }
    
    
    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink));
        signUpLink.click();
        System.out.println("Clicked on Sign Up link.");
    }
}
