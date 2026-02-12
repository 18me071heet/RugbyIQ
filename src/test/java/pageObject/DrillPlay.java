package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DrillPlay {
	
		WebDriver driver;
	    WebDriverWait wait;
	    
	       public DrillPlay(WebDriver driver) {
	    	   
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void verifySessionDrillVideoPlay() throws InterruptedException {
	    
	    WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("a.play-button-session-drill")));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", playBtn);

	    playBtn.click();

	    WebElement video = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.tagName("video")));

	    Assert.assertTrue(video.isDisplayed(), "Video popup did not open");
	    
	    Thread.sleep(8000);
      ((JavascriptExecutor) driver).executeScript("arguments[0].pause();", video);
	

	    }
}
