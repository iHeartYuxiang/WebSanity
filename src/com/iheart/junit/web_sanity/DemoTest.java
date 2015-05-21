package com.iheart.junit.web_sanity;


import com.iheart.selenium.web_sanity.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class DemoTest {

	 WebDriver driver;
		
		HomePage homePage;
		LiveRadioPage liveRadioPage;
		CustomRadioPage customRadioPage;
		PodcastsPage podcastsPage;
		PerfectForPage perfectForPage;
		ProfilePage profilePage;
		
		PopularUserFlow popularFlow;
		
		//String browser = "firefox";
		//rUN in chrome
		String browser = "chrome";
		
		static String userCity = "";
		
		 
		final String URL = "http://www.iheart.com";
		
		@Rule public TestName name = new TestName();
		
		
		@Before
	    public void init() {
	        driver = Utils.launchBrowser(URL, browser);
	        Page.setDriver (driver);
	        homePage = PageFactory.initElements(driver, HomePage.class);
	        liveRadioPage = PageFactory.initElements(driver, LiveRadioPage.class);
	        customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
	        podcastsPage = PageFactory.initElements(driver, PodcastsPage.class);
	        perfectForPage = PageFactory.initElements(driver, PerfectForPage.class);
	        profilePage = PageFactory.initElements(driver, ProfilePage.class);
	        popularFlow = PageFactory.initElements(driver, PopularUserFlow.class);
	        Page.getErrors().delete(0, Page.getErrors().length());
	    }

	    @Test
	    public void testWEB_11784_signUp() throws Exception
	    {
	    	System.out.println("test method:" +  name.getMethodName() );
	    	try{
		    	   homePage.WEB_11784_signUp();
	    	}catch(Exception e)
		 	{
		 		handleException(e);
		 	} 
		     System.out.println(name.getMethodName() + " is Done.");
	    	
	    }
		
		 @Test
		 public void testWEB_11774_filterPodAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		podcastsPage.WEB_11774_filterPodAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 
		 
		 @Test
		 public void testWEB_11741_searchAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_11741_searchAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11762_skipLimit() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11762_skipLimit();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
	 
	    @After
	    public void tearDown() throws Exception{
	    	//driver.quit(); 
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	
	    	//closeBrowserSession();
	    }
	
	    private void handleException(Exception e)
	    {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
            try{
	    	   Page.takeScreenshot(driver, name.getMethodName());
            }catch(Exception eX)
            {
            	
            }
	    }
	    
	    //to handle firefox v37.0 specific issue
	    public void closeBrowserSession() throws Exception 
		  { 
		    	
			  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); 
			 // Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe"); 
			 // Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
		  }
}
