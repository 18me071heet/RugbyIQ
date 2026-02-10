package test;

import org.testng.annotations.Test;

import baseClass.BaseClassRgy;
import pageObject.CreateMyDrill;
import pageObject.CreatePlan;
import pageObject.CreatePlayBook;
import pageObject.CreatePlays;
import pageObject.CreateSession;
import pageObject.CreateTeam;
import pageObject.LogIn;
import pageObject.SearchRecords;

public class SearchRecordsTest extends BaseClassRgy {
	
	@Test(priority=1,description="Search Specific Team")
	public void searchTeam() throws InterruptedException {
		
        LogIn loginPage = new LogIn(driver);
        loginPage.performLogin(getProperty("email"), getProperty("password"));
        
        CreateTeam teamPage = new CreateTeam(driver);
        teamPage.navigateToMyTeams();
        
        Thread.sleep(3000);       
        SearchRecords search = new SearchRecords(driver);
        search.searchRecordName(getProperty("searchTeam"));
        
        Thread.sleep(3000);       
        search.clickSearch();
        
	}
	
	@Test(priority=2,description="Search Specific Plan")
	public void searchPlan() throws InterruptedException {
		
		CreatePlan create = new CreatePlan(driver);
		Thread.sleep(3000);       
		create.goToMyPlans();
		
		SearchRecords search = new SearchRecords(driver);
		search.searchRecordName(getProperty("searchPlan"));
		Thread.sleep(3000);   
		search.clickSearch();
		
	}
	
	@Test(priority=3,description="Search Specific Session")
	public void searchSessions() throws InterruptedException {
        
        CreateTeam teamPage = new CreateTeam(driver);
        Thread.sleep(3000);   
        teamPage.navigateToMyTeams();
        
        CreatePlan planPage = new CreatePlan(driver);
        
        planPage.selectTeam(getProperty("searchTeam"));
        
        CreateSession sessionPage = new CreateSession(driver);
        sessionPage.selectPlan(getProperty("searchPlan"));
        
        Thread.sleep(3000);   
        SearchRecords search = new SearchRecords(driver);
        search.searchRecordName(getProperty("searchSession"));
        Thread.sleep(3000);   
        search.clickSearch();
    
		
	}
	
	@Test(priority=4,description="Search Specific my drill")
	public void searchMyDrill() throws InterruptedException {
        
	    CreateMyDrill drill = new CreateMyDrill(driver);
	    Thread.sleep(2000);
	    drill.clickMyDrillOption();
	      
        Thread.sleep(3000);   
        SearchRecords search = new SearchRecords(driver);
        search.searchRecordName(getProperty("searchMyDrill"));
        Thread.sleep(3000);   
        search.clickSearch();
    
		
	}
	
	@Test(priority=5,description="Search specific playbook")
	public void searchPlayBook() throws InterruptedException {
		
		    CreatePlayBook create = new CreatePlayBook(driver);
	        create.clickPlayBookOption();
	        
	        SearchRecords search = new SearchRecords(driver);
	        Thread.sleep(3000);   
	        search.searchRecordName(getProperty("searchPlayBook"));
	        Thread.sleep(3000);   
	        search.clickSearch();
	        Thread.sleep(4000);
	}
	
	@Test(priority=6,description="Search specific plays")
	public void searchMyPlays() throws InterruptedException {
		
	
	    	CreatePlays plays = new CreatePlays(driver);
			
			plays.selectPlayBook(getProperty("editedPlayBook"));
			
	        SearchRecords search = new SearchRecords(driver);
	        Thread.sleep(3000);   
	        search.searchRecordName(getProperty("searchMyPlays"));
	        Thread.sleep(3000);   
	        search.clickSearch();
	}

}
