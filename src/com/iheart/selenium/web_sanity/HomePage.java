package com.iheart.selenium.web_sanity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import static org.junit.Assert.*; 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;




public class HomePage extends Page {

	

	@FindBy(css="li.genre:nth-child(13) > div:nth-child(1) > div:nth-child(1)")
			public WebElement comedy;		
	
	
	@FindBy(css="li.genre:nth-child(10) > div:nth-child(1) > div:nth-child(3)") public WebElement sport;
	@FindBy(css="button.idle:nth-child(3)") public WebElement playStation;
	@FindBy(css="button.text:nth-child(1)") public WebElement myStation;
	
	
	@FindBy(css="li.genre:nth-child(1) > div:nth-child(1) > div:nth-child(1)") public WebElement firstGenra;
	@FindBy(css=".genre-game-footer > button:nth-child(1)") public WebElement getStation;
	@FindBy(css="li.tabbar:nth-child(1) > a:nth-child(1)") public WebElement forYouLink;
	@FindBy(css="#hero > div.hero-content > div > div.profile-art-wrapper") public WebElement hero;
	@FindBy(css="a.small:nth-child(1)") public WebElement heroEnter;
	
	

	@FindBy(css="#player > div.player-center > div > button.idle.btn-circle.medium.play > i")
		public WebElement playButton;

	//for Z100.com/Popular User Flow
	@FindBy(css="body > div.pageWrapper > div.nowPlayingWrapper.full > div > a > span.cta > span:nth-child(1)")
		private WebElement listenLive;
	
	 public HomePage() {
			
	}
		
	public HomePage(WebDriver driver) {
			super(driver);
	}
	
	//For Most Popular User Flow
	public void  flowAlong()
	{
		listenLive.click();
		makeSureItIsPlaying();
		
		String winHandleBefore = driver.getWindowHandle();
		
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	    //Signup 
		signUp();
		
		
	}
	
	
	public void WEB_11734_startUp()
	{   WaitUtility.sleep(500);
		comedy.click();
		playStation.click();
		
		driver.navigate().refresh();
		sport.click();
		playStation.click();
	}
	
	
	public void WEB_11759_11790_Hero() throws Exception
	{
		
		firstGenra.click();
		getStation.click();
		WaitUtility.sleep(500);
		//makeSureItIsPlaying();
		// assert that player shall appear
	   System.out.println("See text:"+ myStation.getText());
	   
		if(!myStation.getText().contains("Stations"))
			 handleError("Didn't reach My Stations page.", "WEB_11759_11790_Hero" );
		
		//Check for you link
		//check Hero 
		try {
			forYouLink.getText();
			System.out.println("For You link is here.");
		}catch(Exception e)
		{   handleError("For You link is missing.", "WEB_11759_11790_Hero" );
		}
		
		try {
			hero.getText();
		}catch(Exception e)
		{   
			handleError("Hero is missing.", "WEB_11759_forYou");
		}
		
		heroEnter.click();
		
		//Verify that a seperate window is launched
		String winHandleBefore = driver.getWindowHandle();
		
		
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
	    //Check page title of the newly launched window
		System.out.println(driver.getTitle()); 
		
		driver.close();

		//Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}
	
	public void WEB_11735_explorerMenu() throws Exception
	{   String theOption ="";
		String options ="";
		
		 explorer.click();
		 WaitUtility.sleep(1000);
		 
		 //Verify drop down options
		 List<WebElement> allElements = driver.findElements(By.cssSelector("body > div:nth-child(1) > div.header > div.header-wrapper > div > div:nth-child(1) > div > div > nav > ul > li")); 

		 for (WebElement element: allElements) 
	     {   
	    	 theOption = element.getText().trim();
	    	  options += theOption;
	    	 WaitUtility.sleep(500);
	    	
	     }
		 
		 if (!options.contains("For You") || !options.contains("Live Radio") || !options.contains("Custom Radio") 
				 || !options.contains("Genres") || !options.contains("Podcasts") || !options.contains("Perfect For"))
		 {    
			 handleError("Option is missing from the dropdown menu.", "WEB_11735_explorerMenu" );
		 }
		 
		 
		 //Click on each opton of the drop-down menu
		
		 
		 verifyExplorerLink(option_forYou, "Home");
		 verifyExplorerLink(option_liveRadio, "Live");
		 verifyExplorerLink(option_customRadio, "Popular Artists");
		 verifyExplorerLink(option_genres, "Genres");
		 verifyExplorerLink(option_podCasts, "Popular Talk Shows");
		 verifyExplorerLink(option_perfectFor, "Perfect For");
		 
	}
	
	
	
	private void verifyExplorerLink(WebElement option, String expectedTitle)
	{   
		explorer.click();
		WaitUtility.sleep(200);
		String _option = option.getText().trim();
		System.out.println("Verify option:" + _option);
		
		//clickOnExplorerOption(option, expectedTitle);
		gotoExplorerOption(option, expectedTitle);
		
		 System.out.println("See option/ title: "+ _option +"/"+ driver.getTitle());
		 if(!driver.getTitle().contains(expectedTitle))
			 handleError(_option +" link is not working.", "WEB_11735_explorerMenu" );
			 
	}
	
	
	
	public void WEB_11784_signUp()
	{
		firstGenra.click();
		getStation.click();
		playButton.click();
		makeSureItIsPlaying();
	    
		signUp();
	   
	}
	
	
	public void WEB_8823_faceBooksignUp()
	{
		firstGenra.click();
		getStation.click();
		playButton.click();
		makeSureItIsPlaying();
		
		faceBook.click();
		
		String winHandleBefore = switchWindow();
		
		
		faceEmail.sendKeys(FACEBOOKemail);
		facePass.sendKeys("iheart001");
		faceLogin.click();
	    
	    WaitUtility.sleep(2000);
	     
	   // goToPreviousWindow(driver, winHandleBefore);
	    
	    driver.switchTo().window(winHandleBefore);
	    
	  //  String signedAcct = driver.findElement(By.cssSelector("div.dropdown-trigger:nth-child(1) > button:nth-child(1)")).getText();
	    System.out.println("see account:" + signedFBacct.getText());
	    
	    try{
	    	signedFBacct.click();
	    }catch(Exception e)
	    {
	    	errors.append("Facebook Signup failed.");
	    }
	}
	
	
	
	public void WEB_11737_loginWithEmail()
	{
		loginButton.click();
		userName.sendKeys(FACEBOOKemail);
		passWord.sendKeys(_PASSWORD);
		login.click();
		WaitUtility.sleep(2000);
		
		
	    System.out.println("see account:" + signedFBacct.getText());
	    
	    try{
	    	signedFBacct.click();
	    }catch(Exception e)
	    {
	    	errors.append("login with email failed.");
	    }
	}
	
	public void WEB_11739_loginWithGoog()
	{
		do{
			loginButton.click();
			WaitUtility.sleep(1000);
		}while (!driver.getPageSource().contains("Don't have an account?"));
		
		googleButton.click();
		
		//Need to switch Windows here
		
		userName.sendKeys(FACEBOOKemail);
		passWord.sendKeys(_PASSWORD);
		login.click();
		WaitUtility.sleep(2000);
		
	    System.out.println("see account:" + signedFBacct.getText());
	    
	    try{
	    	signedFBacct.click();
	    }catch(Exception e)
	    {
	    	errors.append("login with G+ failed.");
	    }
	}
	
	public void WEB_11740_search()
	{
		searchBox.sendKeys("SUN");
		
		List<WebElement> resultRows = driver.findElements(By.className("search-section"));
		System.out.println(resultRows.size() + " rows are suggested.");
		
		if (resultRows == null || resultRows.size() <1)
	    	errors.append("No suggestion is found.");
	    
	}
	
	
	public void WEB_11742_searchWihoutLogin()
	{   
		search("Pool Party");
		
		search("Elvis Duran");
		
		search("WHTZ");
	
		search("97.1");
		
		search("Bruno Mars");
		
		search("Umbrella");
	}
	
	public void WEB_11741_search()
	{   login();
		search("Pool Party");
	    
	}
	
	
	public void WEB_11902_GeographySearch(String city)
	{   System.out.println("Check user city:" + city);
	    WaitUtility.sleep(1000);
		searchBox.sendKeys("97.1"); 
		
		String topHit = driver.findElement(By.cssSelector(".selected > div:nth-child(2) > p:nth-child(2)")).getText();
		
		System.out.println("userCity/See displayed top hit:" + city + "/" + topHit);
		if(!topHit.contains(city))
			errors.append("Returned top hit is not based on user's geo.");
	}
	
	
}
