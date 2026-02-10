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

public class DeletePlan {

	WebDriver driver;
    WebDriverWait wait;
    
    public DeletePlan(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//a[@id='confirm-delete-plan']")
    WebElement clickRemove;
    
	public void clickRemove() {
		
		wait.until(ExpectedConditions.visibilityOf(clickRemove)).click();
		
	}
	
	public void clickOnRemovePlan() {

	    By removePlanBtn = By.xpath("//a[contains(@class,'delete-plan') and normalize-space()='Remove Plan']");

	    WebElement removePlan = wait.until(
	            ExpectedConditions.elementToBeClickable(removePlanBtn));

	    try {
	        removePlan.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removePlan);
	    }

	    System.out.println("Clicked on Remove Plan");
	}

}
