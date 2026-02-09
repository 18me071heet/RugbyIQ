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

public class EditPlan {

    WebDriver driver;
    WebDriverWait wait;

    public EditPlan(WebDriver driver) {
    	
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//button[normalize-space()='Update']")
    WebElement btnUpdate;
    
    @FindBy(xpath = "//*[contains(text(), 'Edit')]")
    List<WebElement> editOptions;
    
    @FindBy(id = "update_plan_logo")
    WebElement uploadPlanLogoInput;
    
    @FindBy(css = "input.name[name='name']")
    WebElement txtPlanName;
    
    
        public void clickThreeDots(String planName) {
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        String xpath = "//h2[contains(normalize-space(.), '" + planName + "')]/ancestor::div[contains(@class, 'rounded')]//button";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Wait for menu to open
        System.out.println("Clicked on three dots for team: " + planName);
    }
        
        public void clickEdit() {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Current URL before Edit click: " + driver.getCurrentUrl());
            
            WebElement targetEdit = null;
            for (WebElement opt : editOptions) {
                if (opt.isDisplayed()) {
                    targetEdit = opt;
                    break;
                }
            }
            
            if (targetEdit == null && !editOptions.isEmpty()) {
                targetEdit = editOptions.get(editOptions.size() - 1); // Try the last one if none are 'visible'
            }
            
            if (targetEdit != null) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(targetEdit)).click();
                } catch (Exception e) {
                    System.out.println("Normal click failed, trying JS click.");
                    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", targetEdit);
                }
            } else {
                System.out.println("No Edit option found in DOM!");
            }
            
            System.out.println("Clicked on Edit option. Current URL after: " + driver.getCurrentUrl());
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
        }
        
    
        public void uploadPlanLogo(String filePath) {

            // Make hidden input visible
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.display='block'; arguments[0].style.height='1px'; arguments[0].style.width='1px';",
                    uploadPlanLogoInput);

            uploadPlanLogoInput.sendKeys(filePath);

            System.out.println("Plan logo uploaded");
        }
        
        public void clickDeleteIcon() {

            By deleteBtn = By.cssSelector("a.delete_plan_image");

            WebElement deleteIcon = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(deleteBtn));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", deleteIcon);

            try {
                wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
            } catch (Exception e) {
                System.out.println("Normal click failed, using JS click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteIcon);
            }

            System.out.println("Clicked delete icon successfully");
        }
        
        public void editPlanName(String planName) {

            wait.until(ExpectedConditions.visibilityOf(txtPlanName));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", txtPlanName);

            try {
                wait.until(ExpectedConditions.elementToBeClickable(txtPlanName)).click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txtPlanName);
            }

            // React-safe clear
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='';", txtPlanName);

            txtPlanName.sendKeys(planName);

            System.out.println("Team name updated successfully");
        }
        
        public void clickUpdate() {
        	
        	wait.until(ExpectedConditions.visibilityOf(btnUpdate)).click();
        	
        }
        
       
    
}
