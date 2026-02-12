package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteMyDrill {
	
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    public DeleteMyDrill(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath=" //a[normalize-space()='Yes Remove']")
	    WebElement btnRemove;
	    	    
	    public void clickDeleteOption() {

	        By deleteBtn = By.xpath("//div[contains(@id,'dropdown') and contains(@class,'block')]//a[contains(@class,'delete_drill')]");

	        WebElement delete = wait.until(
	                ExpectedConditions.elementToBeClickable(deleteBtn));

	        try {
	            delete.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);
	        }

	        System.out.println("Clicked on DELETE option");
	    }

	    
	    public void removeMyDrill() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(btnRemove)).click();
	    }


}
