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

public class DeleteTeam {

	WebDriver driver;
    WebDriverWait wait;
    
    public DeleteTeam(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//h2[contains(@class, 'text-gray-900')]")
    List<WebElement> teamNamesInListing;
    
     public void clickThreeDots(String teamName) {
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        String xpath = "//h2[contains(normalize-space(.), '" + teamName + "')]/ancestor::div[contains(@class, 'rounded')]//button";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Wait for menu to open
        System.out.println("Clicked on three dots for team: " + teamName);
    }

    public void clickOnRemoveTeam() {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@id,'dropdown-') and contains(@class,'block')]")) );

        WebElement removeBtn = dropdown.findElement(
                By.xpath(".//a[contains(@class,'delete-team-link')]"));

        wait.until(ExpectedConditions.elementToBeClickable(removeBtn));

        removeBtn.click();
    }

    public boolean isTeamNotVisibleInListing(String teamName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.visibilityOfAllElements(teamNamesInListing));

        for (WebElement element : teamNamesInListing) {
            if (element.getText().trim().equalsIgnoreCase(teamName)) {
                return false;   
            }
        }
        return true;
    }
    
    public void clickOnConfirmDeleteTeam() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement deleteBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("confirm-delete-team")));

        deleteBtn.click();
    }
    
}
