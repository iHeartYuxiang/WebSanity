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
		 public void testWEB_11768_addToFavorite() throws Exception
		 {  
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	    perfectForPage.WEB_11768_addToFavorite();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11765_CustomStationPlayStop() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11765_CustomStationPlayStop();
		    }catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		 public void testWEB_11772_browsePodcasts() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	podcastsPage.WEB_11772_browsePodcasts();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 @Test
		 public void testWEB_11754_thumpDownLiveRadio() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try
	    	{
		 	    liveRadioPage.WEB_11754_thumpDown();
	    	}catch(Exception e)
	    	{
	    		handleException(e);
	    	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		/*
		 * 
		 * @Test
		 public void testWEB_11783_logout() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11783_logout();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		@Test
		 public void testWEB_11781_playStationsInListenHistoryPage() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11781_playStationsInListenHistoryPage();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 @Test
		 public void testWEB_11772_browsePodcasts() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	podcastsPage.WEB_11772_browsePodcasts();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11738_FACEBOOKsignUp() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		homePage.WEB_11738_FACEBOOKsignUp();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
	*/
		 
		
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
