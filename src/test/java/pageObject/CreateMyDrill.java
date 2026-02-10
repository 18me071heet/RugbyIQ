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

public class CreateMyDrill {

	    WebDriver driver;
	    WebDriverWait wait;
	    

	    public CreateMyDrill(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath="//span[normalize-space()='My Drills']")
	    WebElement myDrillOption;
	    
	    @FindBy(xpath="//button[@id='myDrill_create_btn']")
	    WebElement clickCreate;
	    
	    @FindBy(xpath="//input[@placeholder='Enter drill name']")
	    WebElement txtDrillName;
	    
	    @FindBy(xpath="//textarea[@placeholder='Write note here ...']")
	    WebElement txtNotes;
	    
	    @FindBy(xpath="//input[@placeholder='Enter URL here..']")
	    WebElement enterUrl;
	    
	    @FindBy(xpath="//button[normalize-space()='Create']")
	    WebElement createBtn;
	    

	    @FindBy(xpath = "//h2[contains(@class, 'text-gray-900')]")
	    List<WebElement> myDrillListing;

	    
	    
	    public void clickMyDrillOption() {
	    	wait.until(ExpectedConditions.visibilityOf(myDrillOption)).click();
	      
	    }
	    
	    public void clickCreate() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(clickCreate)).click();
	    }
	    
	    public void enterDrillName(String drillName) {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(txtDrillName)).sendKeys(drillName);
	    }

	    public void enterNotes(String notes) {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(txtNotes)).sendKeys(notes);
	    }
	    
	    public void enterURL(String url) {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(enterUrl)).sendKeys(url);
	    }
	    
         public void clickCreateBtn() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(createBtn)).click();
	    }
         
         public boolean isMyDrillVisible(String drillName) {
             
             try { Thread.sleep(3000); } catch (InterruptedException e) {}
             
             for (WebElement element : myDrillListing) {
                 String text = element.getText().trim();
                 if (text.equalsIgnoreCase(drillName)) {
                     return true;
                 }
             }
             
             return false;
         }
         
         public void clickOnMyDrill(String drillName) {

        	    drillName = drillName.trim();

        	    String xpath = "//h3[normalize-space()='" + drillName + "']/ancestor::a";

        	    WebElement drill = wait.until(
        	            ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        	    ((JavascriptExecutor) driver)
        	            .executeScript("arguments[0].scrollIntoView({block:'center'});", drill);

        	    ((JavascriptExecutor) driver)
        	            .executeScript("arguments[0].click();", drill);

        	    System.out.println("Clicked on drill: " + drillName);
        	}

         public void clickOnThreeDotByDrillName(String drillName) {

        	    drillName = drillName.trim();

        	    String cardXpath =
        	            "//h3[contains(normalize-space(),'" + drillName + "')]" +
        	            "/ancestor::div[contains(@class,'border')]";

        	    WebElement drillCard = wait.until(
        	            ExpectedConditions.presenceOfElementLocated(By.xpath(cardXpath)));

        	    WebElement threeDotBtn = drillCard.findElement(
        	            By.xpath(".//button[contains(@class,'session-drill-options')]"));

        	    ((JavascriptExecutor) driver)
        	            .executeScript("arguments[0].scrollIntoView({block:'center'});", threeDotBtn);

        	    wait.until(ExpectedConditions.elementToBeClickable(threeDotBtn));

        	    try {
        	        threeDotBtn.click();
        	    } catch (Exception e) {
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", threeDotBtn);
        	    }

        	    System.out.println("Clicked 3-dot menu for drill: " + drillName);
        	}



	    
	    
}
