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
		
		String browser = "firefox";
		
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
		    
		 
		 
		 /*
		  * 
		  * 
		 @Test
		 public void testWEB_11769_skipLimit() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   perfectForPage.WEB_11769_skipLimit();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}   
		 	System.out.println(name.getMethodName() + " is Done.");
		 } 
		 	 
		 @Test
		 public void testWEB_11780_playStationsInMyStationsPage() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		    	profilePage.WEB_11780_playStationsInMyStationsPage();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		 public void testWEB_11777_skipLimitless() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		podcastsPage.WEB_11777_skipLimitless();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
			
		 @Test
		 public void testWEB_11778_pauseResume() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		podcastsPage.WEB_11778_pauseResume();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		    public void testWEB_11796_LiveStationAutoPlay() throws Exception
		    {   
		    	System.out.println("test method:" +  name.getMethodName() );
		    	try {
		    	   liveRadioPage.WEB_11796_LiveStationAutoPlay();
		    	}catch(Exception e)
		    	{
		    		handleException(e);
		    	}
		    	System.out.println(name.getMethodName() + " is Done.");
		    }
		    
		    @Test
		    public void testWEB_11746_PlayStopScan() throws Exception
		    {   
		    	System.out.println("test method:" +  name.getMethodName() );
		    	try
		    	{
		    	   liveRadioPage.WEB_11746_PlayStopScan();
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
		 public void testWEB_11779_playStations() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   profilePage.WEB_11779_playStations();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		  
		   @Test
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
		 
		  
		  *    
		  */
		   
		 
		// ******************************************************************
		
		
		/*
		@Test
		 public void testWEB_11754_thumpDown() throws Exception
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

		 @Test
		 public void testWEB_11770_thumpUpPerfect() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   perfectForPage.WEB_11770_thumpUpPerfect();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		
		@Test
		 public void testWEB_11752_thumpUpLiveRadio() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try
	    	{
		 	   liveRadioPage.WEB_11752_thumpUp();
	    	}catch(Exception e)
	    	{
	    		handleException(e);
	    	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
			
		
	  
	    
		@Test
		 public void testWEB_11776_thumbUpPodcasts() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		podcastsPage.WEB_11776_thumbUp();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
	    */
	 
	    @After
	    public void tearDown() {
	    	
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	driver.quit(); 
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
	    
}
